package session.category;

import domain.Category;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
@Stateless
public class SessionCategory implements SessionCategoryLocal {
    
    @PersistenceContext(unitName = "RoutineBusterEJBPU")
    private EntityManager em;

    @Override
    public Category getCategoryTree() {
        Category category = new Category();
        try {
            List<Category> children
                    = em.createQuery("SELECT c FROM Category c WHERE c.idCate IS NULL").getResultList();
            for (Category child : children) {
                attachChildren(category);
            }
            category.setCategoryList(children);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void deleteCategory(Category category) throws Exception {
        category.setApproved(false);
        updateCategory(category);
    }

    @Override
    public void updateCategory(Category category) throws Exception {
        em.merge(category);
    }

    @Override
    public void addCategory(Category category) throws Exception {
        em.persist(category);
    }

    @Override
    public void approveCategory(Category category) throws Exception {
        category.setApproved(true);
        updateCategory(category);
    }

    @Override
    public List<Category> autocompleteCategory(String name) {
        List<Category> list = null;
        try {
            list = em.createQuery("SELECT c FROM Category c WHERE c.name LIKE :na")
                    .setParameter("na", name + "%").getResultList();
            list = list.subList(0, Math.min(list.size(), 10));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Internal use only.
     *
     * @param category
     */
    @Override
    public void attachChildren(Category category) {
        try {
            List<Category> children = em.createQuery("SELECT c FROM Category c WHERE c.idCate=:cate")
                    .setParameter("cate", category.getIdCat()).getResultList();
            if (children == null) {
                return;
            }
            for (Category child : children) {
                attachChildren(child);
            }
            category.setCategoryList(children);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> autocompleteApproveCategory(String text) {
     List<Category> list = null;
        try {
            List<Category> temp = em.createQuery("SELECT q FROM Category c WHERE c.name LIKE :na")
                    .setParameter("na", text + '%').getResultList();
            list = new ArrayList<Category>(10);
            int i = 0;
            for (Category category : temp) {
                if (!category.getApproved()) {
                    list.add(category);
                    i++;
                    if (i==9) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

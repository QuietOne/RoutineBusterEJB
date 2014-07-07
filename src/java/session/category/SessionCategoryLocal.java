package session.category;

import domain.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
@Local
public interface SessionCategoryLocal {

    Category getCategoryTree();

    void deleteCategory(Category category) throws Exception;

    void updateCategory(Category category) throws Exception;

    void addCategory(Category category) throws Exception;

    void approveCategory(Category category) throws Exception;

    List<Category> autocompleteCategory(String name);

    void attachChildren(Category category);

    public List<Category> autocompleteApproveCategory(String text);

}

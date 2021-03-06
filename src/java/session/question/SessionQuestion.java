package session.question;

import domain.Category;
import domain.Question;
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
public class SessionQuestion implements SessionQuestionLocal {

    @PersistenceContext(unitName = "RoutineBusterEJBPU")
    private EntityManager em;

    @Override
    public List<Question> getQuestions(Category category) {
        List<Question> list = null;
        try {
            list = em.createQuery("SELECT q FROM Question q WHERE q.idCat.idCat=:cat")
                    .setParameter("cat", category.getIdCat()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateQuestion(Question question) throws Exception {
        em.merge(question);
        em.flush();
    }

    @Override
    public void addQuestion(Question question) throws Exception {
        em.persist(question);
    }

    @Override
    public void approveQuestion(Question question) throws Exception {
        question.setApproved(true);
        updateQuestion(question);
    }

    @Override
    public List<Question> autocompleteQuestion(String text) {
        List<Question> list = null;
        try {
            list = em.createQuery("SELECT q FROM Question q WHERE q.text LIKE :te")
                    .setParameter("te", text + "%").getResultList();
            list = list.subList(0, Math.min(list.size(), 10));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

    @Override
    public void deleteQuestion(Question question) throws Exception {
        question.setApproved(false);
        updateQuestion(question);
    }

    @Override
    public List<Question> autocompleteApproveQuestion(String text) {
        List<Question> list = null;
        try {
            List<Question> temp = em.createQuery("SELECT q FROM Question q WHERE q.text LIKE :te")
                    .setParameter("te", text + '%').getResultList();
            list = new ArrayList<Question>(10);
            int i = 0;
            for (Question question : temp) {
                if (!question.getApproved()) {
                    list.add(question);
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

    @Override
    public List<Question> autocompleteDeleteQuestion(String text) {
        List<Question> list = null;
        try {
            List<Question> temp = em.createQuery("SELECT q FROM Question q WHERE q.text LIKE :te")
                    .setParameter("te", text + '%').getResultList();
            list = new ArrayList<Question>(10);
            int i = 0;
            for (Question question : temp) {
                if (question.getApproved()) {
                    list.add(question);
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

    @Override
    public List<Question> getQuestions() {
        List<Question> list = null;
        try {
            list = em.createQuery("SELECT q FROM Question q").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

package session.question;

import domain.Category;
import domain.Question;
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
            list = em.createQuery("SELECT q FROM Question q WHERE q.idCat=:cat")
                    .setParameter("cat", category.getIdCat()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateQuestion(Question question) throws Exception {
        em.merge(question);
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
    public List<String> autocompleteQuestion(String text) {
        List<Question> list = null;
        List<String> questions = null;
        try {
            list = em.createQuery("SELECT q FROM Question q WHERE q.text LIKE :te LIMIT 10")
                    .setParameter("te", text + "%").getResultList();
            for (Question q : list) {
                questions.add(q.getText());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
   

    @Override
    public void deleteQuestion(Question question) throws Exception {
        question.setApproved(false);
        updateQuestion(question);
    }

}

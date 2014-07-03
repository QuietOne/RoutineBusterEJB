package session.answer;

import domain.Answer;
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
public class SessionAnswer implements SessionAnswerLocal {
    @PersistenceContext(unitName = "RoutineBusterEJBPU")
    private EntityManager em;

    @Override
    public List<Answer> getAnswers(Question question) {
        List<Answer> list = null;
        try {
            list = em.createQuery("SELECT a FROM Answer a WHERE a.idQuestion=:question")
                    .setParameter("question", question.getIdQuestion()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    
}

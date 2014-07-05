package session.test;

import domain.Answered;
import domain.Answeritem;
import domain.Test;
import domain.Testitem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
@Stateless
public class SessionTest implements SessionTestLocal {
    @PersistenceContext(unitName = "RoutineBusterEJBPU")
    private EntityManager em;

    @Override
    public void saveTest(Test test) throws Exception {
        em.persist(test);
        for (Testitem testItem : test.getTestitemList()) {
            em.persist(testItem);
        }
        for (Answered answered : test.getAnsweredList()) {
            em.persist(answered);
        }
        for (Answeritem answerItem : test.getAnsweritemList()) {
            em.persist(answerItem);
        }    
    }

    

}

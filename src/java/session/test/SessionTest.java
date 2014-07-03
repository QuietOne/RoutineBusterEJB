package session.test;

import domain.Test;
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
    }

    

}

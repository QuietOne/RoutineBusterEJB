package session.result;

import domain.Result;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
@Stateless
public class SessionResult implements SessionResultLocal {
    @PersistenceContext(unitName = "RoutineBusterEJBPU")
    private EntityManager em;

    @Override
    public void saveResult(Result result) throws Exception {
        em.persist(result);
    }
    
}

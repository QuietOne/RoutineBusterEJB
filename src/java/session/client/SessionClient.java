package session.client;

import domain.Client;
import helper.Validate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tihomir Radosavljevic
 * @author Jelena Tabas
 * @version 1.0
 */
@Stateless
public class SessionClient implements SessionClientLocal {

    @PersistenceContext(unitName = "RoutineBusterEJBPU")
    private EntityManager em;

    /**
     *
     * @param username
     * @param password
     * @return true if there is unique Client with this username and password
     */
    @Override
    public boolean validateLogin(String username, String password) {
        try {
            //it only matters if this can be executed without problem
            em.createQuery("SELECT c FROM Client c WHERE c.username=:u AND c.password=:p")
                    .setParameter("u", username).setParameter("p", password).getSingleResult();
        } catch (NoResultException nre) {
            //no result has been found
            return false;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return true;
    }

    /**
     *
     * @param username
     * @return Client with specific username
     */
    @Override
    public Client getClient(String username) {
        Client client = null;
        try {
            client = (Client) em.createQuery("SELECT c FROM Client c WHERE c.username=:u")
                    .setParameter("u", username).getSingleResult();
        } catch (NoResultException nre) {
            //no result has been found
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return client;
        /*List<Client> clients = null;
         clients = (List<Client>) em.createQuery("SELECT c FROM Client c WHERE c.username=:u")
         .setParameter("u", username).getResultList();
         if (clients != null) {
         return clients.get(0);
         }
         return null;*/
    }

    @Override
    public void updateClient(Client client) throws Exception {
        em.merge(client);
        em.flush();
    }

    @Override
    public void deleteClient(Client client) throws Exception {
        client.setForbiden(true);
        updateClient(client);
    }

    @Override
    public void approveClient(Client client) throws Exception {
        client.setForbiden(false);
        updateClient(client);
    }

    @Override
    public void validateRegister(Client client, String confirmPassword) throws Exception {
        Validate validate = new Validate();
        if (!validate.firstName(client.getName())) {
            throw new Exception("Ime nije dobro unešeno");
        }
        if (!validate.lastName(client.getConame())) {
            throw new Exception("Prezime nije dobro unešeno");
        }
        if (!validateUsername(client.getUsername())) {
            throw new Exception("Korisničko ime nije dobro unešeno");
        }
        if (!validate.password(client.getPassword())) {
            throw new Exception("Korisnička lozinka nije dobro unešena");
        }
        if (!client.getPassword().equals(confirmPassword)) {
            throw new Exception("Šifre se ne poklapaju");
        }
        if (!validate.email(client.getEmail())) {
            throw new Exception("Email nije dobro unešen");
        }
    }

    private boolean validateUsername(String username) {
        Client client = null;
        try {
            client = getClient(username);
        } catch (Exception ex) {
            return false;
        }
        return client == null;
    }

    @Override
    public void addClient(Client client) throws Exception {
        em.persist(client);
    }

    @Override
    public List<Client> autocompleteClient(String username) {
        List<Client> list = null;
        try {
            list = em.createQuery("SELECT c FROM Client c WHERE c.username LIKE :u LIMIT 10")
                    .setParameter("u", username + "%").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void changePassword(String username, String oldPass, String newPass, String confirmPass) throws Exception {
        Validate validate = new Validate();
        Client client = getClient(username);
        if (client.getPassword().equals(oldPass)) {
            validate.changePassword(oldPass, newPass, confirmPass);
            client.setPassword(newPass);
            try {
                updateClient(client);
            } catch (Exception e) {
                throw new Exception("Greska sa serverom");
            }
        } else {
            throw new Exception("Ukucana stara sifra se ne poklapa sa onom koja se nalazi na serveru");
        }
    }

}

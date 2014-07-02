package session.client;

import domain.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
@Local
public interface SessionClientLocal {

    boolean validateLogin(String username, String password);

    Client getClient(String username);

    void updateClient(Client client) throws Exception;

    void deleteClient(Client client) throws Exception;

    void approveClient(Client client) throws Exception;

    void validateRegister(Client client, String confirmPassword) throws Exception;

    void addClient(Client client) throws Exception;

    List<Client> autocompleteClient(String username);

}

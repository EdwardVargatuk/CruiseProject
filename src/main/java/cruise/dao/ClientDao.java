package cruise.dao;

import cruise.Entities.Client;

import java.util.Optional;

/**
 * @author Edward
 */
public interface ClientDao extends CRUDDao<Client> {

    Optional getByLogin(String login);

}
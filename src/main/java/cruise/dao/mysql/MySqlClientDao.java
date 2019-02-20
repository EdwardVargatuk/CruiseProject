package cruise.dao.mysql;

import cruise.Entities.Client;
import cruise.dao.ClientDao;
import cruise.dao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

/**
 * Client DAO implementation
 *
 * @author Edward
 */
public class MySqlClientDao implements ClientDao {

    private Session session;

    MySqlClientDao(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Client> getById(Long id) {
        return Optional.ofNullable(session.find(Client.class, id));
    }

    @Override
    public List<Client> getAll() {
        Query query = session.createQuery("SELECT client FROM Client client");
        return query.getResultList();
    }

    @Override
    public void save(Client client) {
        HibernateUtil.executeInsideTransaction((entityManager -> entityManager.save(client)), session);
    }

    @Override
    public void update(Client client) {
        HibernateUtil.executeInsideTransaction((session -> session.update(client)), session);
    }

    @Override
    public void delete(Client client) {
        HibernateUtil.executeInsideTransaction((session -> session.remove(client)), session);
    }

    @Override
    public Optional getByLogin(String login) {
        Query query = session.getNamedQuery("findClientByName");
        query.setParameter("userName", login);
        return Optional.ofNullable(query.uniqueResult());

    }
}
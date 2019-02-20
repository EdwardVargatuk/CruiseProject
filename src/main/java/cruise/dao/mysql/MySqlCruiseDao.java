package cruise.dao.mysql;


import cruise.Entities.Cruise;
import cruise.dao.CruiseDao;
import cruise.dao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

/**
 * Cruise DAO implementation
 *
 * @author Edward
 */
public class MySqlCruiseDao implements CruiseDao {

    private Session session;

    MySqlCruiseDao(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Cruise> getById(Long id) {
        return Optional.ofNullable(session.find(Cruise.class, id));
    }

    @Override
    public List<Cruise> getAll() {
        Query query = session.createQuery("SELECT cruise FROM Client cruise");
        return query.getResultList();
    }

    @Override
    public void save(Cruise cruise) {
        HibernateUtil.executeInsideTransaction((entityManager -> entityManager.save(cruise)), session);
    }

    @Override
    public void update(Cruise cruise) {
        HibernateUtil.executeInsideTransaction((session -> session.update(cruise)), session);
    }

    @Override
    public void delete(Cruise cruise) {
        HibernateUtil.executeInsideTransaction((session -> session.remove(cruise)), session);
    }

    @Override
    public Cruise getByShipId(Long shipId) {
        Query query = session.getNamedQuery("findCruiseByShipId");
        query.setMaxResults(1);
        query.setFirstResult(0);
        return (Cruise) query.uniqueResult();
    }
}
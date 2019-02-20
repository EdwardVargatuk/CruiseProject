package cruise.dao;

/**
 * factory for entities dao
 *
 * @author Edward
 */
public interface DaoFactory {

    BonusDao getBonusDao();

    ClientDao getClientDao();

    CruiseDao getCruiseDao();

    ExcursionDao getExcursionDao();

    OrderDao getOrderDao();

    PortDao getPortDao();

    ShipDao getShipDao();

}
package cruise.dao;


import cruise.Entities.Cruise;

/**
 * @author Edward
 */
public interface CruiseDao extends CRUDDao<Cruise>{

    Cruise getByShipId(Long shipId);

}



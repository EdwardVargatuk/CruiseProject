package cruise.dao;

import java.util.List;
import java.util.Optional;

/**
 * @param <T> Entity
 * @author Edward
 * <p>
 * CRUD interface
 */
public interface CRUDDao<T> {


    /**
     * @param t create
     */
    void save(T t);

    /**
     * @param id read
     * @return Optional
     */
    Optional<T> getById(Long id);

    /**
     * @param t update
     */
    void update(T t);

    /**
     * @param t delete
     */
    void delete(T t);

    /**
     * @return list of entities
     */
    List<T> getAll();
}

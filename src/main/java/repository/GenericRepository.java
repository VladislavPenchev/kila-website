package repository;

import java.util.List;

public interface GenericRepository<E, Id> {

    E save(E entity);

    List<E> findAll();

    E findById(Id id);

    long size();
}

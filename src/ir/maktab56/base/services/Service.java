package ir.maktab56.base.services;

import ir.maktab56.base.models.Entity;
import ir.maktab56.base.repositories.Repository;

public interface Service<E extends Entity<ID>, ID> {

    E read(E e);

    E save(E e);

    E update(E e);

    E[] readAll();

    E[] findAllById(ID[] ids);

    boolean deleteById(ID id);

    E findById(ID id);

    boolean existsById(ID id);
}

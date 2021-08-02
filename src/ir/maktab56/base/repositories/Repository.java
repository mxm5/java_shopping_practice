package ir.maktab56.base.repositories;

import ir.maktab56.base.models.BaseEntity;
import ir.maktab56.base.models.Entity;

public interface Repository <E extends BaseEntity<ID>,ID>{

    E read(E e);

    E save(E e);

    E update(E e);

    E[] findAll();

    E[] findAllById(ID[] ids);

    boolean deleteById(ID id);

    E findById(ID id);

    boolean existsById(ID id);

}

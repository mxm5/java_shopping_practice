package ir.maktab56.base.repositories;

import ir.maktab56.base.models.BaseEntity;

public class BaseRepository<E extends BaseEntity<ID>, ID> implements Repository<E,ID>{
    @Override
    public E read(E e) {
        return null;
    }

    @Override
    public E save(E e) {
        return null;
    }

    @Override
    public E update(E e) {
        return null;
    }

    @Override
    public E[] findAll() {
        return null;
    }

    @Override
    public E[] findAllById(ID[] ids) {
        return null;
    }

    @Override
    public boolean deleteById(ID id) {
        return false;
    }

    @Override
    public E findById(ID id) {
        return null;
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }
}
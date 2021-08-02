package ir.maktab56.base.services;

import ir.maktab56.base.models.BaseEntity;
import ir.maktab56.base.repositories.BaseRepository;


public class BaseService <E extends BaseEntity<ID>,ID , R extends BaseRepository<E,ID>>   implements Service<E,ID>{

    protected final R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    @Override
    public E read(E e) {
        return repository.read(e);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public E[] findAll() {
        return repository.findAll();
    }

    @Override
    public E[] findAllById(ID[] ids) {
        return repository.findAllById(ids);
    }

    @Override
    public boolean deleteById(ID id) {
        return repository.deleteById(id);
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}

package ir.maktab56.base.repositories;

import ir.maktab56.base.models.BaseEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseRepository<E extends BaseEntity<ID>, ID> implements Repository<E, ID> {


    protected final Connection connection;

    public BaseRepository(Connection connection) {
        this.connection = connection;
        createTable();
    }


    protected abstract void createTable();


    @Override
    public ResultSet basicQuery(String sql) {
        ResultSet resultSet = null;
        try {
            resultSet=connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

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

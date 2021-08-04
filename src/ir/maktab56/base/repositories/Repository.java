package ir.maktab56.base.repositories;

import ir.maktab56.base.models.BaseEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository <E extends BaseEntity<ID>,ID>{

    boolean basicUpdate(String sql);

    ResultSet basicQuery(String sql);

    E read(E e) throws SQLException;

    boolean save(E e);

    boolean update(E e);

    E[] readAll();

    E[] findAllById(ID[] ids);

    boolean deleteById(ID id);

    E findById(ID id);

    boolean existsById(ID id);

}

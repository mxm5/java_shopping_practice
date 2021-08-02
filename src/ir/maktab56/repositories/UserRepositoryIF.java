package ir.maktab56.repositories;

import ir.maktab56.base.repositories.Repository;
import ir.maktab56.models.User;

import java.sql.SQLException;

public interface UserRepositoryIF extends Repository<User,Long>  {

    boolean readByUsrName(User user) ;

    boolean insertNewUser(User user);
}

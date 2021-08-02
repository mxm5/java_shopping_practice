package ir.maktab56.repositories;

import ir.maktab56.base.repositories.BaseRepository;
import ir.maktab56.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepositoryImpl extends BaseRepository<User,Long> implements UserRepository  {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User read(User user)  {

        try {
            ResultSet r =  connection.createStatement().executeQuery("show tables");
            System.out.println(r);
            System.out.println("tables");
            while (r.next()) {
                System.out.println(r.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return super.read(user);
    }
}

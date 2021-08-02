package ir.maktab56.repositories;

import ir.maktab56.base.repositories.BaseRepository;
import ir.maktab56.models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepositoryImpl extends BaseRepository<User,Long> implements UserRepository  {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User read(User user)  {

        try {
            Statement  statement = connection.createStatement();
            statement.executeQuery("select * from users");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return super.read(user);
    }
}

package ir.maktab56.repositories;

import ir.maktab56.base.repositories.BaseRepository;
import ir.maktab56.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepositoryImpl extends BaseRepository<User, Long> implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);

    }

    @Override
    protected void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS `shopping_app`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `firstName` VARCHAR(100) NOT NULL,\n" +
                "  `lastName` VARCHAR(100) NOT NULL,\n" +
                "  `phoneNumber` VARCHAR(14) NULL,\n" +
                "  `userName` VARCHAR(45) NOT NULL,\n" +
                "  `pass` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n" +
                "  UNIQUE INDEX `phoneNumber_UNIQUE` (`phoneNumber` ASC) VISIBLE,\n" +
                "  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE);\n";

        try {
            connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public User read(User user) {

//        try {
//            ResultSet r = connection.createStatement().executeQuery("show tables");
//            System.out.println(r);
//            System.out.println("tables");
//            while (r.next()) {
//                System.out.println(r.getString(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return super.read(user);
    }
}

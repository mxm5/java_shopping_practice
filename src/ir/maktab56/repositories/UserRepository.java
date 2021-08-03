package ir.maktab56.repositories;

import ir.maktab56.base.repositories.BaseRepository;
import ir.maktab56.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepository extends BaseRepository<User, Long> implements UserRepositoryIF {

    public UserRepository(Connection connection) {
        super(connection);
        createTable();
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
//                "  UNIQUE INDEX `phoneNumber_UNIQUE` (`phoneNumber` ASC) VISIBLE,\n" +
                "  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE);\n";

        try {
            connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ResultSet basicQuery(String sql) {
        return super.basicQuery(sql);
    }

    @Override
    public User read(User user) {

        try {
            ResultSet r = basicQuery("SELECT * FROM shopping_app.users WHERE userName = \"" +
                    user.getUsrName() +
                    "\" AND pass = \"" + user.getPass() + "\";");


            if (r.next()) {
                return new User(
                        r.getString("firstName"),
                        r.getString("lastName"),
                        r.getString("userName"),
                        r.getString("phoneNumber"),
                        r.getString("pass"),
                        r.getLong("id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean readByUsrName(User user) {
        boolean exists =false;
        try {
        ResultSet r = basicQuery("SELECT * FROM shopping_app.users WHERE userName = \"" +
                user.getUsrName() +
                "\" ;");
           exists =r.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(exists)
            System.out.println(" a user exits with username "+ user.getUsrName());
        return exists ;
    }

    @Override
    public boolean insertNewUser(User user) {

        int res = 0;
        String sql =String.format("INSERT INTO `shopping_app`.`users` (" +
                        " `firstName`, `lastName`, `phoneNumber`, `userName`, `pass`) \n" +
                "VALUES (" +
                "'%s', " +
                "'%s', " +
                "'%s', " +
                "'%s', " +
                "'%s');",
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getUsrName(),
                user.getPass()
                );
        try {
             res = connection.createStatement().executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res!=0;
    }
}

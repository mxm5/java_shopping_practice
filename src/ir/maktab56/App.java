package ir.maktab56;

import ir.maktab56.models.User;
import ir.maktab56.repositories.UserRepositoryImpl;
import ir.maktab56.views.Home;

import java.sql.*;

public class App {

    public static Connection connection;
    private static boolean existsShopping_app;

    public static void initConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "MKuJNV+3W?%wE&D5");

            System.out.println("created con");

            ResultSet r = connection.createStatement().executeQuery("show schemas;");

            while (r.next()) {

                System.out.println(r.getString(1));
                existsShopping_app = r.getString(1).equals("shopping_app");
                if (existsShopping_app) {
                    break;
                }
            }
            if (!existsShopping_app) {

                connection.createStatement().executeUpdate("CREATE SCHEMA `shopping_app` ;");
            }
            connection.createStatement().executeUpdate("USE `shopping_app`;");



        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

    }

    public static void main(String[] args) {
        initConnection();
        new Home();

    }
}

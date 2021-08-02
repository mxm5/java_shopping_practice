package ir.maktab56;

import java.sql.*;

public class App {

    public static Connection connection;

    public static void initConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "MKuJNV+3W?%wE&D5");
            System.out.println("created con");
            ResultSet r = connection.createStatement().executeQuery("show schemas;");
            while (r.next()) {

                System.out.println(r.getString(1));
                boolean exists = r.getString(1) .equals("shopping_app") ;
                // if exits or not create and use it or else man;
            }

            connection.createStatement().executeUpdate("USE `shopping_app`;");

//            connection.createStatement().executeUpdate("CREATE SCHEMA `shopping_app` ;");
//            connection.setSchema("shopping_app");
//            connection.createStatement().executeUpdate("set search_path to shopping_app;");

            r = connection.createStatement().executeQuery("show tables");
            System.out.println("tables");
            while (r.next()) {
                System.out.println(r.getString(1));

            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

    }

    public static void main(String[] args) {
        initConnection();
    }
}

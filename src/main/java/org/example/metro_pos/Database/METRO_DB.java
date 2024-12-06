package org.example.metro_pos.Database;

import java.sql.*;

public class METRO_DB {

    private static METRO_DB instance;

    private METRO_DB() {
    }

    public static METRO_DB getInstance() {
        if (instance == null) {
            instance = new METRO_DB();

            String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12749635";
            String user = "sql12749635";
            String password = "abAnzPuqJr";

            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                }
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.getCause();
            }
        }
        return instance;
    }


}




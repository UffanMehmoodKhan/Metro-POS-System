package org.example.metro_pos.Database;

import java.sql.*;

// Singleton Class
public class METRO_DB {

    private static METRO_DB instance;
    public static Connection connection;

    private METRO_DB() {
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12749635";
        String user = "sql12749635";
        String password = "abAnzPuqJr";

        try {
            connection = DriverManager.getConnection(url, user, password);
            //connection.close();
        } catch (SQLException e) {
            e.getCause();
        }
    }

    public static METRO_DB getInstance() {
        if (instance == null) {
            instance = new METRO_DB();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    // Validate Cashier Login
    public boolean validateCashier(String username, String password, String branchId) {
        try {
            String query = "SELECT * FROM Cashier WHERE name = ? AND password = ? AND branch_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, branchId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Validate Admin Login
    public boolean validateAdmin(String username, String password, String securityCode) {
        try {
            String query = "SELECT * FROM SuperAdmin WHERE name = ? AND password = ? AND admin_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, securityCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Validate Branch Manager Login
    public boolean validateBranchManager(String username, String password) {
        try {
            String query = "SELECT * FROM BranchManager WHERE name = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Validate Data Operator Login
    public boolean validateDataOperator(String username, String password, String branchCode) {
        try {
            String query = "SELECT * FROM DataEntryOperator WHERE name = ? AND password = ? AND branch_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, branchCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getCashier() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cashier");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + resultSet.getString("password") + resultSet.getString("branch_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBranchManager() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BranchManager");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("branch_manager_id") + resultSet.getString("name") +
                        resultSet.getString("password") + resultSet.getString("branch_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSuperAdmin() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SuperAdmin");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("admin_id") + resultSet.getString("name")
                        + resultSet.getString("password") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDataOperator() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DataEntryOperator");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("data_entry_id") + resultSet.getString("name") +
                        resultSet.getString("password") + resultSet.getString("branch_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Main {

    public static void main(String[] args) throws SQLException {
        METRO_DB metro_db = METRO_DB.getInstance();
        metro_db.getCashier();
        metro_db.getBranchManager();
        metro_db.getSuperAdmin();
        metro_db.getDataOperator();

    }
}




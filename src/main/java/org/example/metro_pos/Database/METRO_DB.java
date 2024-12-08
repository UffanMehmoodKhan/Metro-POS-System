package org.example.metro_pos.Database;

import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction.CashierTransactionRequest;
import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch.SuperAdminBranchRequest;
import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch.SuperAdminBranchResponse;
import org.example.metro_pos.Controllers.SuperAdmin.Dashboard.BranchManager.SuperAdminBranchManagerRequest;
import org.example.metro_pos.Session.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            String query = "SELECT * FROM SuperAdmin WHERE name = ? AND password = ? AND security_pass = ?";
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
    public boolean validateBranchManager(String username, String password, String branchID) {
        try {
            String query = "SELECT * FROM BranchManager WHERE name = ? AND password = ? AND branch_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, Integer.parseInt(branchID));
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

    public ResultSet findProduct(String productBarCode, HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        String branchID = userSession.getBranchID();
        try {
            // Product ID, NAme, category,salePrice,
            String query = "SELECT product_barcode, name, category, sale_price, stock_quantity FROM Product WHERE product_barcode = ? AND branch_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productBarCode);
            preparedStatement.setString(2, branchID);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void updateProducts(CashierTransactionRequest request, HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        String branchID = userSession.getBranchID();
        try {
            for (CashierTransactionRequest.ProductTransaction product : request.getTransactionDetails()) {
                String updateStockQuery = "UPDATE Product SET stock_quantity = stock_quantity - ? WHERE product_barcode = ? AND branch_code = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateStockQuery)) {
                    preparedStatement.setInt(1, product.getQuantity());
                    preparedStatement.setString(2, product.getProductCode());
                    preparedStatement.setString(3, branchID);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SuperAdminBranchResponse> findBranches() {
        List<SuperAdminBranchResponse> branches = new ArrayList<>();
        String query = "SELECT b.branch_code, b.name AS branch_name, b.city, b.address, b.phone, b.num_employees, b.active, " +
                "bm.name AS branch_manager_name, bm.email AS branch_manager_email, bm.salary AS branch_manager_salary " +
                "FROM Branch b LEFT JOIN BranchManager bm ON b.branch_code = bm.branch_code";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SuperAdminBranchResponse branch = new SuperAdminBranchResponse();
                branch.setBranchCode(resultSet.getString("branch_code"));
                branch.setBranchName(resultSet.getString("branch_name"));
                branch.setCity(resultSet.getString("city"));
                branch.setAddress(resultSet.getString("address"));
                branch.setPhone(resultSet.getString("phone"));
                branch.setNumEmployees(resultSet.getInt("num_employees"));
                branch.setActive(resultSet.getBoolean("active"));
                branch.setManagerName(resultSet.getString("branch_manager_name"));
                branch.setManagerEmail(resultSet.getString("branch_manager_email"));
                branch.setManagerSalary(resultSet.getDouble("branch_manager_salary"));
                branches.add(branch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branches;
    }

    // Insert Branch
    public boolean insertBranch(SuperAdminBranchRequest request) {
        System.out.println(request.getBranchCity());
        String query = "INSERT INTO Branch (name, city, address, phone, num_employees, active) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, request.getBranchName());
            preparedStatement.setString(2, request.getBranchCity());
            preparedStatement.setString(3, request.getBranchAddress());
            preparedStatement.setString(4, request.getBranchPhone());
            preparedStatement.setInt(5, request.getNumEmployees());
            preparedStatement.setBoolean(6, request.isBranchActive());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Insert Branch Manager
    public boolean insertBranchManager(SuperAdminBranchManagerRequest request) {
        String query = "INSERT INTO BranchManager (name, email, password, branch_code, salary) VALUES (?, ?, ?, ?, ?)";
        try {
            // Check if branch_code exists in Branch table
            String checkBranchQuery = "SELECT COUNT(*) FROM Branch WHERE branch_code = ?";
            PreparedStatement checkBranchStmt = connection.prepareStatement(checkBranchQuery);
            checkBranchStmt.setString(1, request.getBranchManagerBranchCode());
            ResultSet resultSet = checkBranchStmt.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, request.getBranchManagerName());
                preparedStatement.setString(2, request.getBranchManagerEmail());
                preparedStatement.setString(3, request.getBranchManagerPassword());
                preparedStatement.setString(4, request.getBranchManagerBranchCode());
                preparedStatement.setDouble(5, request.getBranchManagerSalary());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } else {
                System.out.println("Invalid branch code: " + request.getBranchManagerBranchCode());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBranchManager(String branchCode) {
        String query = "DELETE FROM BranchManager WHERE branch_code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, branchCode);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBranch(String branchCode) {
        String deleteBranchManagerQuery = "DELETE FROM BranchManager WHERE branch_code = ?";
        String deleteBranchQuery = "DELETE FROM Branch WHERE branch_code = ?";
        try {
            connection.setAutoCommit(false);

            PreparedStatement deleteBranchManagerStmt = connection.prepareStatement(deleteBranchManagerQuery);
            deleteBranchManagerStmt.setString(1, branchCode);
            deleteBranchManagerStmt.executeUpdate();

            PreparedStatement deleteBranchStmt = connection.prepareStatement(deleteBranchQuery);
            deleteBranchStmt.setString(1, branchCode);
            int rowsAffected = deleteBranchStmt.executeUpdate();

            connection.commit();
            return rowsAffected > 0;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}

//class Main {
//
//    public static void main(String[] args) throws SQLException {
//        METRO_DB metro_db = METRO_DB.getInstance();
//        metro_db.getCashier();
//        metro_db.getBranchManager();
//        metro_db.getSuperAdmin();
//        metro_db.getDataOperator();
//
//    }
//}




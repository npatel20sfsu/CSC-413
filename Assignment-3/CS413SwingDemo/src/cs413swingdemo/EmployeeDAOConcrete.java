package cs413swingdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.HashMap;

/**
 * Concrete implementation of EmployeeDAO interface.
 */
class EmployeeDAOConcrete implements EmployeeDAO {

    private static Connection connection = null;
    private PreparedStatement pStatement;
    private ResultSet result;

    // Constructor
    EmployeeDAOConcrete() {
        try {
            // Establish database connection
            connection = EmployeeDataConnection.getDBConnection();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }



    // Method to get database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = EmployeeDataConnection.getDBConnection();
            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }
        }
        return connection;
    }

    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


    @Override
    public int insert(Employee emp) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(EmployeeDataConnection.getInsert());
        pStatement.setString(1, emp.getUsername());
        pStatement.setString(2, emp.getEmail());
        res = pStatement.executeUpdate();
        disconnect();
        return res;
    }

    @Override
    public Employee get(int anID) throws SQLException {
        pStatement = connection.prepareStatement(EmployeeDataConnection.getSelect());
        pStatement.setInt(1, anID);
        result = pStatement.executeQuery();
        Employee updatedEmp = null;
        if (result.next()) {
            updatedEmp = new Employee(result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("phone"));
        }
        return updatedEmp;
    }

    @Override
    public int update(Employee emp) throws SQLException {
        int result = -1;
        pStatement = connection.prepareStatement(EmployeeDataConnection.getUpdate());
        pStatement.setString(1, emp.getUsername());
        pStatement.setString(2, emp.getEmail());
        pStatement.setString(3, emp.getPhone());
        pStatement.setInt(4, emp.getId());
        result = pStatement.executeUpdate();
        return result;
    }

    @Override
    public int delete(Employee emp) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(EmployeeDataConnection.getDelete());
        pStatement.setInt(1, emp.getId());
        res = pStatement.executeUpdate();
        return res;
    }

    @Override
    public CS413SwingDemo.BankAccount getBankAccount(int accountNumber) throws SQLException {
        return null;
    }

    @Override
    public int saveBankAccount(CS413SwingDemo.BankAccount account) throws SQLException {
        return 0;
    }

    @Override
    public int insertBankAccount(CS413SwingDemo.BankAccount account) throws SQLException {
        return 0;
    }

    @Override
    public int updateBankAccount(CS413SwingDemo.BankAccount account) throws SQLException {
        return 0;
    }

    @Override
    public int deleteBankAccount(CS413SwingDemo.BankAccount account) throws SQLException {
        return 0;
    }

    @Override
    public CS413SwingDemo.Customer getCustomer(int customerID) throws SQLException {
        return null;
    }

    @Override
    public int saveCustomer(CS413SwingDemo.Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int insertCustomer(CS413SwingDemo.Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int updateCustomer(CS413SwingDemo.Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int deleteCustomer(CS413SwingDemo.Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public CS413SwingDemo.Transaction getTransaction(int transactionID) throws SQLException {
        return null;
    }

    @Override
    public int saveTransaction(CS413SwingDemo.Transaction transaction) throws SQLException {
        return 0;
    }

    @Override
    public int insertTransaction(CS413SwingDemo.Transaction transaction) throws SQLException {
        return 0;
    }

    @Override
    public int updateTransaction(CS413SwingDemo.Transaction transaction) throws SQLException {
        return 0;
    }

    @Override
    public int deleteTransaction(CS413SwingDemo.Transaction transaction) throws SQLException {
        return 0;
    }

    @Override
    public int save(Employee emp) throws SQLException {
        int res = -1;
        String[] strArr = emp.getUsername().split(" ");
        pStatement = connection.prepareStatement(EmployeeDataConnection.getInsert());
        pStatement.setString(1, strArr[0]);
        pStatement.setString(2, strArr[1]);
        pStatement.setString(3, emp.getEmail());
        pStatement.setString(4, emp.getPhone());
        pStatement.setString(5, emp.getDepartment());
        res = pStatement.executeUpdate();
        return res;
    }

    // Method to validate login
    public HashMap<String, String> validateLogin(String id) {
        HashMap<String, String> hm = null;
        try {
            pStatement = connection.prepareStatement(EmployeeDataConnection.getAdmin());
            pStatement.setString(1, id);
            result = pStatement.executeQuery();
            if (result.next()) {
                hm = new HashMap<>();
                hm.put("ID", result.getString("userid"));
                hm.put("PWD", result.getString("pwd"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Try again..");
        }
        return hm;
    }
}

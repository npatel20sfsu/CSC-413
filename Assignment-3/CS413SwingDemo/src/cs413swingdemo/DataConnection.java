package cs413swingdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConnection {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/CS413";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1600Holloway@78";

    // JDBC variables for opening and managing connection
    private static Connection myConnection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    // SQL queries for BankAccount
    private static final String INSERT_BANKACCOUNT_SQL = "INSERT INTO BankAccount (accountNumber, balance, type) VALUES (?, ?, ?)";
    private static final String SELECT_BANKACCOUNT_SQL_BY_NUMBER = "SELECT * FROM BankAccount WHERE accountNumber = ?";
    private static final String UPDATE_BANKACCOUNT_SQL = "UPDATE BankAccount SET balance = ?, type = ? WHERE accountNumber = ?";
    private static final String DELETE_BANKACCOUNT_SQL = "DELETE FROM BankAccount WHERE accountNumber = ?";

    // SQL queries for Customer
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO Customer (customerID, name, email, phone) VALUES (?, ?, ?, ?)";
    private static final String SELECT_CUSTOMER_SQL_BY_ID = "SELECT * FROM Customer WHERE customerID = ?";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE Customer SET name = ?, email = ?, phone = ? WHERE customerID = ?";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM Customer WHERE customerID = ?";

    // SQL queries for Transaction
    private static final String INSERT_TRANSACTION_SQL = "INSERT INTO Transaction (transactionID, amount, type) VALUES (?, ?, ?)";
    private static final String SELECT_TRANSACTION_SQL_BY_ID = "SELECT * FROM Transaction WHERE transactionID = ?";
    private static final String UPDATE_TRANSACTION_SQL = "UPDATE Transaction SET amount = ?, type = ? WHERE transactionID = ?";
    private static final String DELETE_TRANSACTION_SQL = "DELETE FROM Transaction WHERE transactionID = ?";

    public DataConnection()  { }

    public static Connection getDBConnection() throws SQLException {
        myConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return myConnection;
    }

    // Methods to get SQL queries for BankAccount operations
    public static String getInsertBankAccountSQL() {
        return INSERT_BANKACCOUNT_SQL;
    }

    public static String getSelectBankAccountSQLByNumber() {
        return SELECT_BANKACCOUNT_SQL_BY_NUMBER;
    }

    public static String getUpdateBankAccountSQL() {
        return UPDATE_BANKACCOUNT_SQL;
    }

    public static String getDeleteBankAccountSQL() {
        return DELETE_BANKACCOUNT_SQL;
    }

    // Methods to get SQL queries for Customer operations
    public static String getInsertCustomerSQL() {
        return INSERT_CUSTOMER_SQL;
    }

    public static String getSelectCustomerSQLByID() {
        return SELECT_CUSTOMER_SQL_BY_ID;
    }

    public static String getUpdateCustomerSQL() {
        return UPDATE_CUSTOMER_SQL;
    }

    public static String getDeleteCustomerSQL() {
        return DELETE_CUSTOMER_SQL;
    }

    // Methods to get SQL queries for Transaction operations
    public static String getInsertTransactionSQL() {
        return INSERT_TRANSACTION_SQL;
    }

    public static String getSelectTransactionSQLByID() {
        return SELECT_TRANSACTION_SQL_BY_ID;
    }

    public static String getUpdateTransactionSQL() {
        return UPDATE_TRANSACTION_SQL;
    }

    public static String getDeleteTransactionSQL() {
        return DELETE_TRANSACTION_SQL;
    }
}

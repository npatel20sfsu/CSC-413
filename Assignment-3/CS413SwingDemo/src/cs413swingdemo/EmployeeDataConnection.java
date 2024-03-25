package cs413swingdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for establishing database connection and providing SQL queries.
 */
public class EmployeeDataConnection {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/CS413";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1600Holloway@78";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    // SQL queries to be used to persist business objects as needed by the DAO
    private static final String INSERT_SQL = "INSERT INTO Employees (username, email) VALUES (?, ?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM Employees WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE Employees SET username = ?, email = ?, phone = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Employees WHERE id = ?";
    private static final String SELECT_ADMIN = "SELECT * FROM admin WHERE userid = ?";

    public EmployeeDataConnection()  { }

    // Method to establish database connection
    public static Connection getDBConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    // Getter methods for SQL queries
    public static String getInsert() {
        return INSERT_SQL;
    }

    public static String getUpdate() {
        return UPDATE_SQL;
    }

    public static String getSelect() {
        return SELECT_SQL_BYID;
    }

    public static String getDelete() {
        return DELETE_SQL;
    }

    public static String getURL() {
        return URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPWD() {
        return PASSWORD;
    }

    public static String getAdmin() {
        return SELECT_ADMIN;
    }
}

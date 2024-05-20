/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author karunmehta
 */
public class DataConnection {
    
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/CSC413";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Nidhey@1007";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;   
    
    private static final String SELECT_ADMIN = "SELECT * FROM admin WHERE userid = ?";
    
    
    public static Connection getDBConnection() {
        
        if(connection == null) {
           
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);                
            } catch(SQLException sqle) {
                System.out.println("Error getting DB Connection: " + sqle.getMessage());
                
            }

        }
        
        return connection;
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

    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public static void setPreparedStatement(PreparedStatement preparedStatement) {
        DataConnection.preparedStatement = preparedStatement;
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    public static void setResultSet(ResultSet resultSet) {
        DataConnection.resultSet = resultSet;
    }
}

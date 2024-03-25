package cs413swingdemo;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Data Transfer Object for Employee objects.
 */
public class EmployeeDTO {

    private int id;
    private String username;
    private String email;
    private String phone;

    static EmployeeDAOConcrete ed = new EmployeeDAOConcrete();

    // Constructors
    public EmployeeDTO() {
    }

    public EmployeeDTO(int empID, String username, String email) {
        this.username = username;
        this.email = email;
        id = empID;
    }

    public EmployeeDTO(String username, String email, String ph) {
        this.username = username;
        this.email = email;
        this.phone = ph;
    }

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String ph) {
        this.phone = ph;
    }

    public int getID() {
        return id;
    }

    public void setID(int anID) {
        this.id = anID;
    }

    // Method to fetch an Employee by ID
    public static Employee getEmployeeByID(int anId) {
        Employee anEmployee = null;
        try {
            anEmployee = ed.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        return anEmployee;
    }

    // Method to perform an update operation on an Employee
    public static int performUpdate(Employee anEmployee) {
        int updateResult = -1;
        try {
            updateResult = ed.update(anEmployee);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        return updateResult;
    }

    // Method to validate user login
    public static HashMap<String, String> validateUser(String id) {
        return ed.validateLogin(id);
    }

    // Method to perform creation of an Employee
    public static int performCreate(Employee anEmployee) {
        int updateResult = -1;
        try {
            updateResult = ed.save(anEmployee);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        return updateResult;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoanddaodemo;

import java.sql.SQLException;

/**
 *
 * @author karunmehta
 */
public class EmployeeDTO {
    
    private int id;
    private String username;
    private String email;
    private String phone;
    private String birthday;
    private String sex;
   
    static EmployeeDAOConcrete ed = new EmployeeDAOConcrete();

    public EmployeeDTO(String name, String email, String phone, String birthday, String sex) {
        // Default constructor

    }

    public EmployeeDTO(int empID, String username, String email, String phone, String birthday, String sex) {
        this.username = username;
        this.email = email;
        id = empID;
        this.phone = phone;
        this.birthday = birthday;
        this.sex = sex;
    }

    public EmployeeDTO(String username, String email, String phone) {
        this.username = username;
        this.email = email;
        this.phone = phone;
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
        this.phone = phone;
    }

    public String getBirthday() {return birthday;}

    public void setBirthday(String bd) {this.birthday = birthday;}

    public String getSex() {return sex;}

    public void setSex(String sx) {this.sex = sex;}
    
    public int getID() {return id;}

    public void setID(int anID) {
        this.id = anID;
    }  
    
    public static Employee employeeByID(int anId) {

        Employee anEmployee = null;

        try {
            anEmployee = ed.get(anId);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (anEmployee != null) {
            System.out.println(anEmployee.toString());
            System.out.println("\nFetched Employee with ID: " + anId + " Employee Details:\n" + anEmployee.toString());
        } else {
            System.out.println("\nEmployee with ID " + anId + " not found.");
        }
        return anEmployee;
    }

    
    public static int performUpdate(Employee anEmployee) {

        int updateResult = -1;
        
        try {
            updateResult = ed.update(anEmployee);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Employee Details:\n" + anEmployee.toString());
        return updateResult;        
    }

}

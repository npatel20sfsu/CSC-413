/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dtoanddaodemo;

import java.sql.Connection;
import java.sql.SQLException;
import org.modelmapper.ModelMapper;

/**
 *
 * @author karunmehta
 */
public class DTOAndDAODemo {

    /**
     * @param args the command line arguments
     */
    
    static Connection conn;
    private final static EmployeeDAOConcrete ed = new EmployeeDAOConcrete();
    static String sampleUsername = "Nidhey Patel";
    static String sampleEmail = "pnidhey@sfsu.edu";
    static String samplePhone = "123-456-789";
    static String sampleBirthday = "01/01/2000";
    static String sampleSex = "Male";
             
    
    public static void main(String[] args) {

        Employee emp;
        int updateID = 2;
        int fetchID = 1;

        try {
            conn = EmployeeDataConnection.getDBConnection();            
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        //Fetch an employee with the given ID
        emp = performFetch(fetchID);
        
        //Create an employee to update
        emp = new Employee(updateID, sampleUsername, sampleEmail, samplePhone, sampleBirthday, sampleSex);
        
        performUpdate(emp);
        
        //disconnect db connection
        try {
            EmployeeDAOConcrete.disconnect();
        } catch(SQLException se) {
            System.out.println("Exception trying to close connection. Message: \n" + se.getMessage());
        }
        
        testModelMapper();
        
    }
    
    private static Employee performFetch(int empID) {
        
        return EmployeeDTO.employeeByID(empID);
        
    }
    
    private static int performUpdate(Employee anEmployee) {
        
        return EmployeeDTO.performUpdate(anEmployee);
        
    }    
    
    private static void testModelMapper() {
        
        //create model mapper
        ModelMapper modelMapper = new ModelMapper();
        
        //Create Data Transfer Object based on Business Object
        EmployeeDTO employeeDTO = new EmployeeDTO(sampleUsername, sampleEmail, samplePhone, sampleBirthday, sampleSex);
        
        //Create Business Object from the DTO Object
        Employee anEmployee = modelMapper.map(employeeDTO, Employee.class); 
        
        System.out.println("\nSuccessfully mapped and unmapped employee with ID: " + anEmployee.getID() + " with employee Details:\n" + anEmployee.toString());
    }

}


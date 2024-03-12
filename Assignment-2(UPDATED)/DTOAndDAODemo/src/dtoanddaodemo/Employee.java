/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoanddaodemo;

/**
 *
 * @author karunmehta
 */
public class Employee {
    
   private String username;
   private String email;
   private String phone;
   private String sex;
   private String birthday;
   private int id;

    public Employee() {
        // Default constructor
    }

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Employee(int id, String username, String email, String phone, String birthday, String sex) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.birthday = birthday;
        this.sex = sex;
    }
    
    public void getEmployee(int i) {
        
        EmployeeDTO empDTO = buildDTO(this.getID(), this.getUsername(), this.getEmail(),
                this.getPhone(), this.getBirthday(), this.getSex());
               
        this.setID(empDTO.getID());
        this.setUsername(empDTO.getUsername());
        this.setEmail(empDTO.getEmail());
        this.setPhone(empDTO.getPhone());
        this.setBirthday(empDTO.getBirthday());
        this.setSex(empDTO.getSex());

    }
    
    public static EmployeeDTO buildDTO(int empID, String name, String email, String phone, String birthday, String sex){
        
        EmployeeDTO theDTO = new EmployeeDTO(empID, name, email, phone, birthday, sex);
        return theDTO;
        
    }
    

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID() {
        return id;
    }

    public void setID(int idNum) {
        this.id = idNum;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {return sex;}

    public void setSex(String sex){this.sex = sex;}

    
    @Override
    public String toString() {
        
        String empString = "Employee:" + " ID-" + this.getID() + ", Name-" + this.getUsername() + ", Email-" +
                this.getEmail() + ", Phone-" + this.getPhone() +", Birthday-" + this.getBirthday() +
                ", Sex-" + this.getSex();
        return empString;
    }
    
}

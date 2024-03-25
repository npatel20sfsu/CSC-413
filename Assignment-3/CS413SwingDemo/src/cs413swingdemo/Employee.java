package cs413swingdemo;

/**
 * Represents an Employee entity in the application.
 */
public class Employee {

    private String username;
    private String email;
    private String phone;
    private int id; // Changed to int for consistency
    private String department; // Added department field
    private char sex; // Added sex field
    private String birthday; // Added birthday field

    // Default constructor
    public Employee() {
    }

    // Constructor with username and email parameters
    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Constructor with full parameters
    public Employee(int id, String username, String email, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    // Getter and Setter methods for fields

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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // Overridden toString() method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

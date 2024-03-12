/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsondemo;

/**
 *
 * @author terre
 */
public class BankCustomer {


    String firstName;
    String lastName;
    CustomerAddress address;

    // creating costructor for BankCustomer class;
    BankCustomer(String fn, String ln, CustomerAddress addr)
    {

        this.firstName = fn;
        this.lastName = ln;
        this.address = addr;
    }
    //Creating getter functions for BankCustomer class
    public String getFirstName()
    {
    return this.firstName;
    }
    public String getLastName()
    {
    return this.lastName;
    }
    public CustomerAddress getAddress() {
        return this.address;
    }
    // Creating setter functions for BankCustomer class
    public void setFirstName(String firstName)
    {
    this.firstName=firstName;
    }
    public void setLastName(String lastName)
    {
    this.lastName=lastName;
    }
    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    public String getName()
    {
    return this.firstName+","+this.lastName;
    }

    
    public String toString() {
        
        String str = "Customer object: \n";
        
        str += "First Name --> " + this.getFirstName() + "\nLast Name --> " + this.getLastName() + "\n"
                + this.getAddress().toString();
        
        return str;
    }

}

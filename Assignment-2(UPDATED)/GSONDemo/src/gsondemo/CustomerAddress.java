/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsondemo;

/**
 *
 * @author Karun Mehta
 */
public class CustomerAddress {
    int number;
    String street;
    String city;
    String state;
    int zip;
    
    // creating costructor for Bank Account class;
    // we could have initialized the member variable in constructor but it was not required in the question.
    // variable can be set using setter functions


    
    public CustomerAddress(int num, String str, String cty, String st, int z) {

        street = str;
        number = num;
        city = cty;
        state = st;
        zip = z;
    }

    // creating getter functions for CustomerAddress class
    public int getNumber()
    {
    return number;
    }
    public String getStreet()
    {
    return street;
    }
    public String getCity()
    {
    return city;
    }
    public String getState()
    {
    return state;
    }
    public int getZip()
    {
    return zip;
    }
    // creating setter functions for CustomerAddress class
    public void setNumber( int number)
    {
    this.number=number;
    }
    public void setStreet( String street)
    {
    this.street=street;
    }
    public void setCity( String city)
    {
    this.city=city;
    }
    public void setState( String state)
    {
    this.state=state;
    }
    public void setZip( int zip)
    {
    this.zip=zip;
    }
    // defining printAddress() function to print full address of current customer
    public String toString()
    
    {
        String add = "";
        
        add += "Number --> " + this.number + "\nStreet --> " + this.street
                    + "\nCity --> " + this.city + "\nState --> " + this.state + "\nZip --> " + this.zip;
        
        return add;
    }

}


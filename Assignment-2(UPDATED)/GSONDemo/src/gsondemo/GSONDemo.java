/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gsondemo;

import com.google.gson.*;
import com.google.gson.GsonBuilder;
import java.lang.reflect.*;
import java.text.*;
import java.lang.reflect.Type;

/**
 *
 * @author karunmehta
 */
public class GSONDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BankCustomer bc = createBankCustomer();
        System.out.println("BankCustomer created.");
        
        String aGson = javaObjectToGSONConvert(bc);
        System.out.println("BankCustomer object converted to following GSON:");
        System.out.println(aGson);
        
        BankCustomer bs = simpleGSONToJavaObjectConvert(aGson);
        System.out.println("\nGSON converted back to BankCustomer. BankCustomer Object details as follows:");
        System.out.println("First Name: " + bs.firstName);
        System.out.println("Last Name: " + bs.lastName);
        System.out.println("\nAddress: \n" + bs.getAddress().toString());
        
        //Using GSONBuilder to forconverting GSON to Java Object
        gsonBuilder();
       
    }

    class CustomerAddressInstanceCreator implements InstanceCreator<CustomerAddress> {
       public CustomerAddress createInstance(Type type)
       {
          return new CustomerAddress(2333,"Test", "CR","CA",94536);
       }
    }    
  
    private static String javaObjectToGSONConvert(BankCustomer bc){
        
        Gson gson = new Gson();
        String json = gson.toJson(bc);
        return json;
        
    }
    
    private static BankCustomer simpleGSONToJavaObjectConvert(String jsonString){
        
        Gson gson = new Gson();
        BankCustomer bc = gson.fromJson(jsonString, BankCustomer.class);
        return bc;
        
    }    
  
    public static BankCustomer createBankCustomer() {

        BankCustomer bc = new BankCustomer("Nidhey", "Patel", null);

        CustomerAddress ca = new CustomerAddress(2333, "Village Lane", "Fremont", "CA", 94536);
        bc.address = ca;
        
        return bc;
        
    }
 
    
    private static void gsonBuilder() {

        
        BankCustomer bc = null;
        String bcString = "{\"firstName\":\"Karun\",\"lastName\":\"Mehta\",\"address\":{\"number\":2333,\"street\":\"Village Lane\",\"city\":\"Fremont\",\"state\":\"CA\",\"zip\":94536}}";
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        
        //gsonBuilder.registerTypeAdapter(BankCustomer.class, new IdTypeAdapter());
        Gson gson = gsonBuilder.create();
        
        try {
            bc = (BankCustomer) gs.fromJson(bcString , Class.forName("BankCustomer") );
        } catch(ClassNotFoundException cnf) {
            
            System.out.println(cnf.getMessage());
        }       
        
        System.out.println("Details of BankCustomer, as built by GsonBuilder:\n" + bc.toString());
    }

}

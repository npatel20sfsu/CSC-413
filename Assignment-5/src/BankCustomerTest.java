// BankCustomerTest.java

public class BankCustomerTest {
    public static void main(String[] args) {
        // Creating a BankCustomer using the Builder pattern
        BankCustomer bankCustomer = new BankCustomer.BankCustomerBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withAccountNumber("1234567890")
                .withBalance(1000.0)
                .build();

        // Printing the details of the BankCustomer
        System.out.println("Bank Customer Details:");
        System.out.println("First Name: " + bankCustomer.getFirstName());
        System.out.println("Last Name: " + bankCustomer.getLastName());
        System.out.println("Account Number: " + bankCustomer.getAccountNumber());
        System.out.println("Balance: $" + bankCustomer.getBalance());
    }
}

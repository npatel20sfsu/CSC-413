import java.util.Date;

// BankCustomer class
public class BankCustomer {
    private String firstName;
    private String lastName;
    private String accountNumber;
    private double balance;

    // Constructor
    private BankCustomer(String firstName, String lastName, String accountNumber, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Builder class
    public static class BankCustomerBuilder {
        private String firstName;
        private String lastName;
        private String accountNumber;
        private double balance;

        public BankCustomerBuilder() {
        }

        public BankCustomerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public BankCustomerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public BankCustomerBuilder withAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public BankCustomerBuilder withBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public BankCustomer build() {
            return new BankCustomer(firstName, lastName, accountNumber, balance);
        }
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}

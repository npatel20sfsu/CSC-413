package cs413swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CS413SwingDemo extends JFrame {

    private JTextField empID, empName, empPhone, empEmail;
    private JTextField accountNumber, accountBalance, accountType;
    private JTextField customerID, customerName, customerEmail, customerPhone;
    private JTextField transactionID, transactionAmount, transactionType;

    public CS413SwingDemo() {
        setTitle("Employee Create Form");
        setSize(400, 400); // Increased height to accommodate additional components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2)); // Increased rows to accommodate new components

        // Existing components for employee information
        JLabel empNameLabel = new JLabel("Employee Name:");
        empName = new JTextField();
        JLabel empEmailLabel = new JLabel("Employee Email:");
        empEmail = new JTextField();
        JLabel empPhoneLabel = new JLabel("Employee Phone:");
        empPhone = new JTextField();
        JLabel empIDLabel = new JLabel("Employee ID:");
        empID = new JTextField();

        // New components for BankAccount information
        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumber = new JTextField();
        JLabel accountBalanceLabel = new JLabel("Account Balance:");
        accountBalance = new JTextField();
        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountType = new JTextField();

        // New components for Customer information
        JLabel customerIDLabel = new JLabel("Customer ID:");
        customerID = new JTextField();
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerName = new JTextField();
        JLabel customerEmailLabel = new JLabel("Customer Email:");
        customerEmail = new JTextField();
        JLabel customerPhoneLabel = new JLabel("Customer Phone:");
        customerPhone = new JTextField();

        // New components for Transaction information
        JLabel transactionIDLabel = new JLabel("Transaction ID:");
        transactionID = new JTextField();
        JLabel transactionAmountLabel = new JLabel("Transaction Amount:");
        transactionAmount = new JTextField();
        JLabel transactionTypeLabel = new JLabel("Transaction Type:");
        transactionType = new JTextField();

        // Adding components to the panel
        panel.add(empIDLabel);
        panel.add(empID);
        panel.add(empNameLabel);
        panel.add(empName);
        panel.add(empEmailLabel);
        panel.add(empEmail);
        panel.add(empPhoneLabel);
        panel.add(empPhone);

        // Adding BankAccount components to the panel
        panel.add(accountNumberLabel);
        panel.add(accountNumber);
        panel.add(accountBalanceLabel);
        panel.add(accountBalance);
        panel.add(accountTypeLabel);
        panel.add(accountType);

        // Adding Customer components to the panel
        panel.add(customerIDLabel);
        panel.add(customerID);
        panel.add(customerNameLabel);
        panel.add(customerName);
        panel.add(customerEmailLabel);
        panel.add(customerEmail);
        panel.add(customerPhoneLabel);
        panel.add(customerPhone);

        // Adding Transaction components to the panel
        panel.add(transactionIDLabel);
        panel.add(transactionID);
        panel.add(transactionAmountLabel);
        panel.add(transactionAmount);
        panel.add(transactionTypeLabel);
        panel.add(transactionType);

        // Submit button with action listener
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener((ActionEvent e) -> {
            // Creating and displaying Employee object
            int id = Integer.parseInt(empID.getText());
            String name = empName.getText();
            String ph = empPhone.getText();
            String em = empEmail.getText();
            Employee anEmployee = new Employee(id, name, em, ph);
            System.out.println("Details of the Employee: " + anEmployee);

            // Creating and displaying BankAccount object
            int accNumber = Integer.parseInt(accountNumber.getText());
            double accBalance = Double.parseDouble(accountBalance.getText());
            String accType = accountType.getText();
            BankAccount bankAccount = new BankAccount(accNumber, accBalance, accType);
            System.out.println("Details of the Bank Account: " + bankAccount);

            // Creating and displaying Customer object
            int custID = Integer.parseInt(customerID.getText());
            String custName = customerName.getText();
            String custEmail = customerEmail.getText();
            String custPhone = customerPhone.getText();
            Customer customer = new Customer(custID, custName, custEmail, custPhone);
            System.out.println("Details of the Customer: " + customer);

            // Creating and displaying Transaction object
            int transID = Integer.parseInt(transactionID.getText());
            double transAmount = Double.parseDouble(transactionAmount.getText());
            String transType = transactionType.getText();
            Transaction transaction = new Transaction(transID, transAmount, transType);
            System.out.println("Details of the Transaction: " + transaction);
        });
        panel.add(submitButton);

        // Adding panel to JFrame and making it visible
        add(panel);
        setVisible(true);
    }

    public class BankAccount {
        private int accNumber;
        private double balance;
        private String accountType;

        public BankAccount(int accNumber, double accBalance, String accType) {
            this.accNumber = accNumber;
            this.balance = accBalance;
            this.accountType = accType;
        }

        public int getAccNumber() {
            return accNumber;    // Getter for accountNumber
        }
        public double getBalance() {
            return balance;          // Getter for balance
        }
        public String getAccountType() {
            return accountType;   // Getter for accountType
        }

        public void setAccNumber(int accNumber) {
            this.accNumber = accNumber;   // Setter for accountNumber
        }
        public void setBalance(double balance) {
            this.balance = balance;   // Setter for balance
        }
        public void setAccountType(String accountType) {
            this.accountType = accountType;   // Setter for accountType
        }

    }

    public class Customer {
        private int custID;
        private String name;
        private String customerEmail;
        private String contactInfo;

        public Customer(int custID, String custName, String custEmail, String custPhone) {
            this.custID = custID;
            this.name = custName;
            this.customerEmail = custEmail;
            this.contactInfo = custPhone;
        }

        public int getCustID() {
            return custID;
        }
        public String getName() {
            return name;
        }
        public String getCustomerEmail() {
            return customerEmail;
        }
        public String getContactInfo() {
            return contactInfo;
        }

        public void setCustID(int custID) {
            this.custID = custID;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }
        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }


    }

    public class Transaction {
        private int transactionId;
        private double amount;
        private String transactionType;

        public Transaction(int transID, double transAmount, String transType) {
            this.transactionId = transID;
            this.amount = transAmount;
            this.transactionType = transType;
        }

        public int getTransactionId() {
            return transactionId;
        }
        public double getAmount() {
            return amount;
        }
        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionId(int transactionId) {
            this.transactionId = transactionId;
        }
        public void setAmount(double amount) {
            this.amount = amount;
        }
        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(CS413SwingDemo::new);
        /*createDemoEmployeeObjects();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CS413SwingDemo();
            }
        });

         */
    }

    // Method to create demo Employee objects (public and non-static)
    public void createDemoEmployeeObjects() {
        Employee emp1 = new Employee(44, "John Doe", "johndoe@sfsu.edu", "615.555.1212");
        Employee emp2 = new Employee(71, "Jane Deo", "janedoe@sfsu.edu", "615.555.1212");
        Employee emp3 = new Employee(88, "Sam Doe", "johndoe@sfsu.edu", "615.555.1212");
        Employee emp4 = new Employee(22, "April Doe", "janedoe@sfsu.edu", "615.555.1212");
    }
}

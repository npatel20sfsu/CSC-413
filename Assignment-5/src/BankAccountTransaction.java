import java.util.Date;


// Transaction interface
interface Transaction {
    void execute();
}

// Concrete command class for deposit transaction
class DepositTransaction implements Transaction {
    private BankAccount account;
    private double amount;
    private Date datetime;
    private String description;

    public DepositTransaction(BankAccount account, double amount, String description) {
        this.account = account;
        this.amount = amount;
        this.datetime = new Date();
        this.description = description;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("Deposit of $" + amount + " successful. New balance: $" + account.getBalance());
    }
}

// Concrete command class for withdrawal transaction
class WithdrawTransaction implements Transaction {
    private BankAccount account;
    private double amount;
    private Date datetime;
    private String description;

    public WithdrawTransaction(BankAccount account, double amount, String description) {
        this.account = account;
        this.amount = amount;
        this.datetime = new Date();
        this.description = description;
    }

    @Override
    public void execute() {
        if (account.getBalance() >= amount) {
            account.withdraw(amount);
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal of $" + amount + " failed.");
        }
    }
}

// BankAccountTransaction class
public class BankAccountTransaction {
    private int id;
    private Date datetime;
    private String type;
    private double amount;
    private String description;
    private String sourceAccount;
    private String destinationAccount;
    private String status;
    private BankAccount account;

    public BankAccountTransaction(int id, BankAccount account, String type, double amount, String description) {
        this.id = id;
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.datetime = new Date();
        this.status = "Pending";
    }

    public void executeTransaction(Transaction transaction) {
        transaction.execute();
        this.status = "Executed";
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}

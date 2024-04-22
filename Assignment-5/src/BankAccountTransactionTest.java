// BankAccountTransactionTest.java

public class BankAccountTransactionTest {
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount account = new BankAccount("1234567890", 1000.0);

        // Creating deposit and withdrawal transactions
        Transaction depositTransaction = new DepositTransaction(account, 500.0, "Deposit transaction");
        Transaction withdrawTransaction = new WithdrawTransaction(account, 200.0, "Withdrawal transaction");

        // Creating a BankAccountTransaction object
        BankAccountTransaction bankTransaction = new BankAccountTransaction(1, account, "Deposit", 500.0, "Deposit transaction");

        // Executing the transactions
        bankTransaction.executeTransaction(depositTransaction);
        bankTransaction.executeTransaction(withdrawTransaction);
    }
}

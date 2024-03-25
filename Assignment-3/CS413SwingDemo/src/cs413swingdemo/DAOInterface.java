package cs413swingdemo;

import java.sql.SQLException;
import java.util.List;


public interface DAOInterface<T> {

    // Methods for CRUD operations on Employee objects
    T get(int id) throws SQLException;
    //List<T> getAll() throws SQLException;
    int save(T e) throws SQLException;
    int insert(T e) throws SQLException;
    int update(T e) throws SQLException;
    int delete(T e) throws SQLException;

    // Additional methods for CRUD operations on BankAccount objects
    CS413SwingDemo.BankAccount getBankAccount(int accountNumber) throws SQLException;
    //List<BankAccount> getAllBankAccounts() throws SQLException;
    int saveBankAccount(CS413SwingDemo.BankAccount account) throws SQLException;
    int insertBankAccount(CS413SwingDemo.BankAccount account) throws SQLException;
    int updateBankAccount(CS413SwingDemo.BankAccount account) throws SQLException;
    int deleteBankAccount(CS413SwingDemo.BankAccount account) throws SQLException;

    // Additional methods for CRUD operations on Customer objects
    CS413SwingDemo.Customer getCustomer(int customerID) throws SQLException;
    //List<Customer> getAllCustomers() throws SQLException;
    int saveCustomer(CS413SwingDemo.Customer customer) throws SQLException;
    int insertCustomer(CS413SwingDemo.Customer customer) throws SQLException;
    int updateCustomer(CS413SwingDemo.Customer customer) throws SQLException;
    int deleteCustomer(CS413SwingDemo.Customer customer) throws SQLException;

    // Additional methods for CRUD operations on Transaction objects
    CS413SwingDemo.Transaction getTransaction(int transactionID) throws SQLException;
    //List<Transaction> getAllTransactions() throws SQLException;
    int saveTransaction(CS413SwingDemo.Transaction transaction) throws SQLException;
    int insertTransaction(CS413SwingDemo.Transaction transaction) throws SQLException;
    int updateTransaction(CS413SwingDemo.Transaction transaction) throws SQLException;
    int deleteTransaction(CS413SwingDemo.Transaction transaction) throws SQLException;


}

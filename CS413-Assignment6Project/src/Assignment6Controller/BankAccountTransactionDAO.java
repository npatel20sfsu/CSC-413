package Assignment6Controller;

public class BankAccountTransactionDAO {

    private String transactionType;
    private String transactionAmount;
    private String transactionDate;

    public BankAccountTransactionDAO(String transactionType, String transactionAmount, String transactionDate) {
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String toString() {
        return transactionType + " " + transactionAmount + " " + transactionDate;
    }

    public boolean equals(Object o) {
        if (o instanceof BankAccountTransactionDAO) {
            BankAccountTransactionDAO other = (BankAccountTransactionDAO) o;
            return this.transactionType.equals(other.transactionType) &&
                    this.transactionAmount.equals(other.transactionAmount) &&
                    this.transactionDate.equals(other.transactionDate);
        }
        return false;
    }

    public int hashCode() {
        return transactionType.hashCode() + transactionAmount.hashCode() + transactionDate.hashCode();
    }


}

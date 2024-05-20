package Assignment6Controller;

public class BankAccountTransactionDTO {

    private String transactionType;
    private double amount;
    private String date;
    private String time;

    public BankAccountTransactionDTO(String transactionType, double amount, String date, String time) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString() {
        return "Transaction Type: " + transactionType + "\n" +
                "Amount: " + amount + "\n" +
                "Date: " + date + "\n" +
                "Time: " + time;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccountTransactionDTO other = (BankAccountTransactionDTO) obj;
        if (!this.transactionType.equals(other.transactionType)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (!this.date.equals(other.date)) {
            return false;
        }
        if (!this.time.equals(other.time)) {
            return false;
        }
        return true;
    }





}

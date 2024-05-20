package Assignment6Controller;

public class AccountDTO {

    private String accountNumber;
    private String accountType;
    private String accountBalance;
    private String accountName;
    private String accountEmail;
    private String accountPhone;
    private String accountAddress;
    private String accountCity;
    private String accountState;
    private String accountZip;
    private String accountCountry;
    private String accountDate;

    public AccountDTO(String accountNumber, String accountType, String accountBalance, String accountName, String accountEmail, String accountPhone, String accountAddress, String accountCity, String accountState, String accountZip, String accountCountry, String accountDate) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.accountName = accountName;
        this.accountEmail = accountEmail;
        this.accountPhone = accountPhone;
        this.accountAddress = accountAddress;
        this.accountCity = accountCity;
        this.accountState = accountState;
        this.accountZip = accountZip;
        this.accountCountry = accountCountry;
        this.accountDate = accountDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public String getAccountCity() {
        return accountCity;
    }

    public String getAccountState() {
        return accountState;
    }

    public String getAccountZip() {
        return accountZip;
    }

    public String getAccountCountry() {
        return accountCountry;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public void setAccountCity(String accountCity) {
        this.accountCity = accountCity;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public void setAccountZip(String accountZip) {
        this.accountZip = accountZip;
    }

    public void setAccountCountry(String accountCountry) {
        this.accountCountry = accountCountry;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public String toString() {
        return "AccountDTO{" + "accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance=" + accountBalance + ", accountName=" + accountName + ", accountEmail=" + accountEmail + ", accountPhone=" + accountPhone + ", accountAddress=" + accountAddress + ", accountCity=" + accountCity + ", accountState=" + accountState + ", accountZip=" + accountZip + ", accountCountry=" + accountCountry + ", accountDate=" + accountDate + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountDTO other = (AccountDTO) obj;
        if (!this.accountNumber.equals(other.accountNumber)) {
            return false;
        }
        if (!this.accountType.equals(other.accountType)) {
            return false;
        }
        if (!this.accountBalance.equals(other.accountBalance)) {
            return false;
        }
        if (!this.accountName.equals(other.accountName)) {
            return false;
        }
        if (!this.accountEmail.equals(other.accountEmail)) {
            return false;
        }
        if (!this.accountPhone.equals(other.accountPhone)) {
            return false;
        }
        if (!this.accountAddress.equals(other.accountAddress)) {
            return false;
        }
        if (!this.accountCity.equals(other.accountCity)) {
            return false;
        }
        if (!this.accountState.equals(other.accountState)) {
            return false;
        }
        if (!this.accountZip.equals(other.accountZip)) {
            return false;
        }
        if (!this.accountCountry.equals(other.accountCountry)) {
            return false;
        }
        if (!this.accountDate.equals(other.accountDate)) {
            return false;
        }
        return true;
    }
}

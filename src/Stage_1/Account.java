package banking;

public class Account {
    private final String AccountNumber;
    private final String PIN;
    private double balance;

    public Account(String accountNumber, String PIN) {
        AccountNumber = accountNumber;
        this.PIN = PIN;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getPIN() {
        return PIN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

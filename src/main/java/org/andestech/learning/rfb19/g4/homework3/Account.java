package org.andestech.learning.rfb19.g4.homework3;

public abstract class Account {
    private int accountId;
    private double balance;
    private Customer customer;
    protected AccountType accType;

    public abstract boolean withdrawal(double amount) throws AccountException;
    public abstract boolean putMoney(double amount) throws AccountException;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws AccountException {
        if (checkLimits(balance))
            this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccType() {
        return accType;
    }

    @Override
    public String toString() {
        return String.format("ID: [%d] balance: [%,.2f] [%s]", accountId, balance, customer);
    }

    public boolean checkLimits(double balance) throws AccountException {
        double limitLow, limitHigh;
        String message;

        limitLow = accType.getLimitLow();
        limitHigh = accType.getLimitHigh();

        if (balance <  limitLow) {
            message = String.format("Остаток упадет ниже минимума (%,.2f). Операция отклонена! %s\n", balance, this);
            throw new AccountException(message);
        }
        if (balance > limitHigh) {
            message = String.format("Превышен лимит средств на счете (%,.2f). Операция отклонена! %s\n", balance, this);
            throw new AccountException(message);
        }

        return true;
    }

    public boolean checkWithdrawal(double amount, AccountType accType) throws AccountException {
        double limitWithdrawal = accType.getLimitWithdrawal();
        String message;

        if (amount > limitWithdrawal) {
            message = String.format("Превышен лимит снятия средств (%,.2f). Операция отклонена! %s\n", amount, this);
            throw new AccountException(message);
        }

        return checkLimits(balance - amount);
    }

    public boolean checkPutMoney(double amount) throws AccountException {
        return checkLimits(balance + amount);
    }
}

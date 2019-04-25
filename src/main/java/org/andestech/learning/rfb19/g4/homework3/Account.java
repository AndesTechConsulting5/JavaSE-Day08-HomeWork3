package org.andestech.learning.rfb19.g4.homework3;

public abstract class Account {

    private final long  accountId;
    private final Customer customer;
    private double balance;

    public Account(long accountId, Customer customer, double balance) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = balance;
    }

    protected abstract void withdrawal(double delta);
    protected abstract void putMoney(double amount);

    public long getAccountId() {
        return accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

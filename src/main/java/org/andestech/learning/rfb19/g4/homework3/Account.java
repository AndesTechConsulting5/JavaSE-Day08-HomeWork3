package org.andestech.learning.rfb19.g4.homework3;


public abstract class Account {
    private Customer customer;
    private double balance;
    private int accountId;

    public Customer getCustomer() {return customer;}

    public double getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBalance(double balance) { this.balance = balance; }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public abstract double withdrawal(double money) throws Exception;

    public abstract double putMoney(double money) throws Exception;
}

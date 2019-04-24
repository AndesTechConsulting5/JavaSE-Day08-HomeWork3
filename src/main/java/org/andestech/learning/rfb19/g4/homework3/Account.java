package org.andestech.learning.rfb19.g4.homework3;

public abstract class Account {

    private int accountId;
    private static double balance;
    private Customer customer = new Customer();

    private static final double MAX_BALANCE = 1_400_000, MIN_BALANCE = -100_000,
    DELTA_MIN = 100, DELTA_MAX = 10_000;


    public Account() {
    }

    public Account(int accountId, double balance, Customer customer) {
        this.accountId = accountId;
        this.balance = balance;
        this.customer = customer;
    }



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
        if(!isNewBalanceValid(balance)) {
            return;
        }
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public boolean isNewBalanceValid(double balance) throws AccountException {
        if(balance <= MAX_BALANCE && balance >= MIN_BALANCE) {
            return true;
        } else {
            throw new AccountException("Неверный баланс!" + balance);
        }
    }

    public boolean isDeltaValid(double delta) throws AccountException {
        if(delta>=0 && delta <= DELTA_MAX && delta >= DELTA_MIN) {
            return true;
        } else {
            throw new AccountException("Неправильная сумма перевода =" + delta);
        }

    }



    public abstract void withdrawal(double money) throws AccountException;
    public abstract void putMoney(double money) throws AccountException;



}

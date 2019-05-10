package org.andestech.learning.rfb19.g4.homework3;

import org.andestech.learning.rfb19.g4.homework3.Exceptions.CreditAccountException;
import org.andestech.learning.rfb19.g4.homework3.Exceptions.DebitAccountException;

public abstract class Account {

    private int accountId;
    private Customer customer;
    private double balance;
    protected AccType accType;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBalance(double balance) {
        if (checkLimit(balance))
        this.balance = balance;
    }

    public AccType getAccType(){
        return accType;
    }

    public double getBalance() {
        return balance;
    }

    public void putMoney(double delta) throws CreditAccountException, DebitAccountException {
        this.balance += delta;
    }

    public void withdrawal(double delta) throws CreditAccountException, DebitAccountException {
        this.balance -= delta;
    }

    //check limit
    protected boolean checkLimit(double amount){
        double minLimit = accType.getMinLimit();
        double maxLimit = accType.getMaxLimit();

        if(amount < minLimit){
            System.out.println("For " + getAccType() + " limit less than minimum.\n" +
                               " min limit = " + accType.getMinLimit() + "\n" +
                               "Actual balance = " + balance + " actual amount = " + String.format("%.2f", amount));
            return false;
        }
        else if (amount > maxLimit){
            System.out.println("For " + getAccType() + " limit more than maximum.\n" +
                               " max limit = " + accType.getMaxLimit() + "\n" +
                               "Actual balance = " + balance + " actual amount = " + String.format("%.2f", amount));
            return false;
        }
        else {return true;}
    }

    //check delta
    protected boolean checkDelta(double delta){
        double accDelta = accType.getAccDelta();

        if(delta > accDelta){
            System.out.println("Put and withdrawal sum for " + getAccType() + " should be less than " + accType.getAccDelta() + "\n" +
                               " actual sum = " + String.format("%.2f", delta));
            return false;
        } else {
            return true;
        }
    }

}

package org.andestech.learning.rfb19.g4.homework3;

import org.andestech.learning.rfb19.g4.homework3.exception.DebitAccountException;

public class DebitAccount extends Account {

    private static final double MIN_DEBIT_BALANCE = 10;
    private static final double MAX_DEBIT_BALANCE = 1_000_000_000;

    private static final double MIN_DEBIT_DELTA = 1;
    private static final double MAX_DEBIT_DELTA = 1_000_000;

    public DebitAccount(long accountId, Customer customer) {
        super(accountId, customer, MIN_DEBIT_BALANCE);
    }

    @Override
    public void withdrawal(double delta) {
       checkDelta(delta);
       checkBalance(getBalance() - delta);
       setBalance(getBalance() - delta);
    }

    @Override
    public void putMoney(double delta) {
        checkDelta(delta);
        checkBalance(getBalance() + delta);
        setBalance(getBalance() + delta);
    }

    @Override
    public String toString() {
        return String.format("Debit account[id: %d, customer: %s, balance: %.2f]", getAccountId(), getCustomer().toString(), getBalance());
    }

    private void checkBalance(double balance) {
         if(!(MIN_DEBIT_BALANCE <= balance && balance <= MAX_DEBIT_BALANCE)){
             throw new DebitAccountException("Incorrect balance: " + balance);
         }
    }
    private void checkDelta(double delta){
        if(!(MIN_DEBIT_DELTA <= delta && delta <= MAX_DEBIT_DELTA)){
            throw new DebitAccountException("Incorrect delta: " + delta);
        }
    }
}

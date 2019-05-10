package org.andestech.learning.rfb19.g4.homework3;

import org.andestech.learning.rfb19.g4.homework3.Exceptions.CreditAccountException;
import org.andestech.learning.rfb19.g4.homework3.Exceptions.DebitAccountException;

public class CreditAccount extends Account {

    private static final int MIN_AGE = 14;

    private CreditAccount(int accountId, Customer customer, double balance) {
        this.accType = AccType.CreditAccount;
        this.setAccountId(accountId);
        this.setCustomer(customer);
        this.setBalance(balance);
    }

    public static CreditAccount createCreditAccount(boolean isCreditHistoryCorrect, int customerAge, Customer customer, double balance, int accountId) throws CreditAccountException{
        if(isCreditHistoryCorrect && customerAge <= MIN_AGE){
            throw new CreditAccountException("Can't open credit account because credit history or age is not valid!\n" + "credit history = " + isCreditHistoryCorrect + " age = " + customerAge);
            //System.out.println("Can't open credit account because credit history or age is not valid!\n" + "credit history = " + isCreditHistoryCorrect + " age = " + customerAge);
            //return null;
        }
        return new CreditAccount(accountId, customer, balance);
    }

    @Override
    public void putMoney(double sum) throws CreditAccountException, DebitAccountException {
        if (checkDelta(sum) && checkLimit(getBalance() + sum)){
            super.putMoney(sum);
        } else throw new CreditAccountException("Error putMoney CreditAccount");
    }

    @Override
    public void withdrawal(double sum) throws CreditAccountException, DebitAccountException {
        if (checkDelta(sum) && checkLimit(getBalance() - sum)){
            super.withdrawal(sum);
        } else throw new CreditAccountException("Error withdrawal CreditAccount");
    }
}

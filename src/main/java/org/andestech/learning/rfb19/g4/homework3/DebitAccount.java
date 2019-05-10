package org.andestech.learning.rfb19.g4.homework3;

import org.andestech.learning.rfb19.g4.homework3.Exceptions.CreditAccountException;
import org.andestech.learning.rfb19.g4.homework3.Exceptions.DebitAccountException;

public class DebitAccount extends Account{

    public DebitAccount(int accountId, Customer customer, double balance) {
        this.accType = AccType.DebitAccount;
        this.setAccountId(accountId);
        this.setCustomer(customer);
        this.setBalance(balance);
    }

    @Override
    public void putMoney(double sum) throws DebitAccountException, CreditAccountException {
        if (checkDelta(sum) && checkLimit(getBalance() + sum)){
            super.putMoney(sum);
        } else throw new DebitAccountException("Error putMoney DebitAccount");
    }

    @Override
    public void withdrawal(double sum) throws DebitAccountException, CreditAccountException {
        if (checkDelta(sum) && checkLimit(getBalance() - sum)){
            super.withdrawal(sum);
        } else throw new DebitAccountException("Error withdrawal DebitAccount");
    }
}

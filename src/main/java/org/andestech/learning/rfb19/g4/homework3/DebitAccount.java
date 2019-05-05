package org.andestech.learning.rfb19.g4.homework3;

public class DebitAccount extends Account {

    public DebitAccount(int accountId, Customer customer, double balance) throws DebitAccountException {
        this.accType = AccountType.DebitAccount;
        this.setAccountId(accountId);
        this.setCustomer(customer);
        try {
            this.setBalance(balance);
        } catch (AccountException e) {
            throw new DebitAccountException(e.getMessage());
        }
    }

    public DebitAccount(int accountId, Customer customer) throws DebitAccountException {
        this(accountId, customer, 0);
    }

    @Override
    public boolean withdrawal(double amount) throws DebitAccountException {
        try {
            if (!checkWithdrawal(amount, this.getAccType()))
                return false;
            setBalance(getBalance() - amount);
        } catch (AccountException e) {
            throw new DebitAccountException(e.getMessage());
        }

        return true;
    }

    @Override
    public boolean putMoney(double amount) throws DebitAccountException {
        try {
            if (!checkPutMoney(amount))
                return false;
            setBalance(getBalance() + amount);
        } catch (AccountException e) {
            throw new DebitAccountException(e.getMessage());
        }

        return true;
    }

    @Override
    public String toString() {
        return "{" + accType + " " + super.toString() + "}";
    }
}

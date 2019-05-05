package org.andestech.learning.rfb19.g4.homework3;

import java.util.Random;

public class CreditAccount extends Account {

    private CreditAccount(int accountId, Customer customer, double balance) throws CreditAccountException {
        this.accType = AccountType.CreditAccount;
        this.setAccountId(accountId);
        this.setCustomer(customer);
        try {
            this.setBalance(balance);
        }
        catch (AccountException e) {
            throw new CreditAccountException(e.getMessage());
        }

    }

    public static CreditAccount createAccount(int accountId, Customer customer, double balance) throws CreditAccountException {
        String message;
        if (customer.getAge() < 18 || customer.getAge() > 65) {
            message = String.format("Account ID: [%d] Несоответствие возраста! balance: [%,.2f] %s\n", accountId, balance, customer);
            throw new CreditAccountException(message);
        }
        if (!customer.isCreditHistoryGood()) {
            message = String.format("Account ID: [%d] Плохая кредитная история! balance: [%,.2f] %s\n", accountId, balance, customer);
            throw new CreditAccountException(message);
        }
        if (balance < AccountType.CreditAccount.getLimitLow() || balance > AccountType.CreditAccount.getLimitHigh()) {
            message = String.format("Account ID: [%d] Недопустимый баланс! balance: [%,.2f] %s\n", accountId, balance, customer);
            throw new CreditAccountException(message);
        }
        if (accountId < 1) {
            message = String.format("Account ID: [%d] Недопустимый ID! balance: [%,.2f] %s\n", accountId, balance, customer);
            throw new CreditAccountException(message);
        }

        return new CreditAccount(accountId, customer, balance);
    }

    @Override
    public boolean withdrawal(double amount) throws AccountException {
        try {
            if (!checkWithdrawal(amount, this.getAccType()))
                return false;
            setBalance(getBalance() - amount);
        }
        catch (AccountException e) {
            throw new CreditAccountException(e.getMessage());
        }

        return true;
    }

    @Override
    public boolean putMoney(double amount) throws CreditAccountException {
        try {
            if (!checkPutMoney(amount))
                return false;
            setBalance(getBalance() + amount);
        } catch (AccountException e) {
            throw new CreditAccountException(e.getMessage());
        }

        return true;
    }

    @Override
    public String toString() {
        return "{" + accType + " " + super.toString() + "}";
    }
}

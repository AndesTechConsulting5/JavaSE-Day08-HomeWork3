package org.andestech.learning.rfb19.g4.homework3;

import org.andestech.learning.rfb19.g4.homework3.exception.CreditAccountException;

import java.util.Objects;

public class CreditAccount extends Account {

    private static final double MIN_CREDIT_BALANCE = 10;
    private static final double MAX_CREDIT_BALANCE = 1_000_000_000;

    private static final double MIN_CREDIT_DELTA = 1;
    private static final double MAX_CREDIT_DELTA = 1_000_000;

    private CreditAccount(long accountId, Customer customer) {
        super(accountId, customer, MIN_CREDIT_BALANCE);
    }

    public static CreditAccount createCreditAccount(long accountId, Customer customer) {
        CreditCustomerValidator.checkCustomer(customer);
        return new CreditAccount(accountId, customer);
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
        return String.format("Credit account[id: %d, customer: %s, balance: %.2f]", getAccountId(), getCustomer().toString(), getBalance());
    }

    private void checkDelta(double delta) {
        if (!(MIN_CREDIT_DELTA <= delta && delta <= MAX_CREDIT_DELTA)) {
            throw new CreditAccountException("Incorrect delta: " + delta);
        }
    }

    private void checkBalance(double balance) {
        if (!(MIN_CREDIT_BALANCE <= balance && balance <= MAX_CREDIT_BALANCE)) {
            throw new CreditAccountException("Incorrect balance: " + balance);
        }
    }

    private static class CreditCustomerValidator {

        private static final int MIN_AGE = 21;
        private static final int MAX_AGE = 65;

        public static boolean checkCustomer(Customer customer){
            Objects.requireNonNull(customer, "Customer must not be null");
            checkAge(customer);
            checkAddress(customer);
            checkBKI(customer);

            return true;
        }

        public static void checkAddress(Customer customer) {
            if(Objects.isNull(customer.getAddress()))
                throw new CreditAccountException("Address must not be null");
        }

        public static void checkAge(Customer customer) {
            int age = customer.getAge();
            if(MIN_AGE > age || age > MAX_AGE)
                throw new CreditAccountException("Age incorrect:" + age);
        }

        public static void checkBKI(Customer customer) {
            if(customer.getFirstName().startsWith("Z")){
                throw new CreditAccountException("BKI not pass");
            }
        }
    }
}

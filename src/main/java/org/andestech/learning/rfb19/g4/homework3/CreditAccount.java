package org.andestech.learning.rfb19.g4.homework3;

import java.util.Random;

public class CreditAccount extends Account {

    private static final int MIN_BALANCE = 50, MAX_BALANCE = 100_000;
    private static final int MIN_AGE = 18, MAX_AGE = 60;
    private static final int MIN_MONEY = 100, MAX_MONEY=3000;

    @Override
    public double withdrawal (double money) throws CreditAccountException {
        double newBalance = getBalance() - money;
        if (money < MIN_MONEY) {
            throw new CreditAccountException("Минимальная сумма снятия " + MIN_MONEY + " рублей.");
        } else if (money > MAX_MONEY){
            throw new CreditAccountException("Максимальная сумма снятия с кредитного счета за одну операцию " + MAX_MONEY  + " рублей.");
        }
        if (newBalance < MIN_BALANCE){
            throw new CreditAccountException ("Баланс не может быть меньше допустимого минимума в " + MIN_BALANCE + " рублей.");
        } else if (newBalance > MAX_BALANCE){
            throw new CreditAccountException ("Баланс не может превышать допустимый максимум в " + MAX_BALANCE + " рублей.");
        }
        setBalance(newBalance);
        return newBalance;
    }

    @Override
    public double putMoney(double money) throws CreditAccountException {
        double newBalance = getBalance() + money;
        if (money < MIN_MONEY) {
            throw new CreditAccountException("Минимальная сумма пополнения счета " + MIN_MONEY + " рублей.");
        }
        if (newBalance < MIN_BALANCE) {
            throw new CreditAccountException("Баланс не может быть меньше допустимого минимума в " + MAX_BALANCE + " рублей.");
        } else if (newBalance > MAX_BALANCE) {
            throw new CreditAccountException("Баланс не может быть меньше допустимого минимума в " + MAX_BALANCE + " рублей.");
        }
        setBalance(newBalance);
        return newBalance;
    }

    Random random = new Random();
    int cr = random.nextInt(999_999);

    private CreditAccount(Customer customer) {
        this.setCustomer(customer);
        this.setBalance(50);
        this.setAccountId(cr);
    }

    @Override
    public String toString() {
        return getCustomer().toString() + "; На сумму = " + getBalance() + " руб.; ID = " + getAccountId();
    }

    public static CreditAccount createAcc(boolean ch, Customer customer) throws CreditAccountException {
        if (ch == true && customer.getAge() >= MIN_AGE && customer.getAge() <= MAX_AGE) {
            System.out.println("Счет успешно открыт.");
            return new CreditAccount(customer);
        } else if (ch != true){
            throw new CreditAccountException("Счет не может быть открыт, плохая кредитная история.");
        } else if (customer.getAge() < MIN_AGE) {
            throw new CreditAccountException("Счет не может быть открыт, клиент моложе 18 лет.");
        } else if (customer.getAge() > MAX_AGE) {
            throw new CreditAccountException("Счет не может быть открыт, клиент старше 60 лет.");
        }
        else {
            return null;
        }
    }
}
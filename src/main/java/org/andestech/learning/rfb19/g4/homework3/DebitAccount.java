package org.andestech.learning.rfb19.g4.homework3;

import java.util.Random;

public class DebitAccount extends Account {

    private static final int MIN_BALANCE = 100, MAX_BALANCE = 1_000_000;
    private static final int MIN_MONEY = 100, MAX_MONEY=3000;


    Random random = new Random();
    int dr = random.nextInt(999_999);

    public DebitAccount(Customer customer){
        this.setCustomer(customer);
        this.setBalance(0);
        this.setAccountId(dr);
    }

    @Override
    public double withdrawal (double money) throws DebitAccountException {
        double newBalance = getBalance() - money;
        if (money < MIN_MONEY) {
            throw new DebitAccountException("Минимальная сумма снятия за одну операцию " + MIN_MONEY + " рублей.");
        }
            if (newBalance < MIN_BALANCE) {
                throw new DebitAccountException("Баланс не может быть меньше допустимого минимума в " + MIN_BALANCE + " рублей.");
            } else if (newBalance > MAX_BALANCE) {
                throw new DebitAccountException("Баланс не может превышать допустимый максимум в " + MAX_BALANCE + " рублей.");
            }
            setBalance(newBalance);
            return newBalance;
        }

    @Override
    public double putMoney ( double money) throws CreditAccountException{
        double newBalance = getBalance() + money;
        if (newBalance < MIN_BALANCE){
            throw  new CreditAccountException("Баланс не может быть меньше допустимого минимума в " + MIN_BALANCE + " рублей.");
        } else if (newBalance > MAX_BALANCE){
            throw  new CreditAccountException ("Баланс не может превышать допустимый максимум в " + MAX_BALANCE + " рублей.");
        }
        setBalance(newBalance);
        return newBalance;
    }
}
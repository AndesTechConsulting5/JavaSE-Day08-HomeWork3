package org.andestech.learning.rfb19.g4.homework3;

public class CreditAccount extends Account {

    private CreditAccount() {
    }

    private CreditAccount(int accountId, double balance, Customer customer) {
        super(accountId, balance, customer);
    }


    public static CreditAccount create() {return new CreditAccount();}

    //фабричный метод
    public static CreditAccount createAccount(int id, double balance, Customer customer) throws CreditAccountException, CustomerException {
        if(customer.getAge() < 18 || customer.getAge() > 70) {
            throw new CustomerException("Возраст не подходит!");
        } else if (balance < 0) {
            throw new CreditAccountException("Отрицательный баланс!");
        } else {
            System.out.println("Создание кредитного счета с балансом:" + balance);
            return new CreditAccount(id, balance, customer);
        }
    }




    @Override
    public void withdrawal(double money) throws AccountException {
        System.out.println("Снимаем деньги с кредитного счета.");
        if(isDeltaValid(money)) {
            double balance = getBalance() - money;
            setBalance(balance);
            System.out.println("На счету " + balance);
        }
    }

    @Override
    public void putMoney(double money) throws AccountException {
        System.out.println("Кладем деньги на кредитный счет.");
        if(isDeltaValid(money)) {
            double balance = getBalance() + money;
            setBalance(balance);
            System.out.println("На счету " + balance);
        }
    }
}

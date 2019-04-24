package org.andestech.learning.rfb19.g4.homework3;

public class DebitAccount extends Account {


    public DebitAccount() {
    }

    public DebitAccount(int accountId, double balance, Customer customer) {
        super(accountId, balance, customer);
    }



    //фабричный метод
    public static DebitAccount debitAccount(int id, double balance, Customer customer) throws DebitAccountException, CustomerException {
        if(customer.getAge() < 18) {
            throw new CustomerException("Возраст не подходит!");
        } else {
            System.out.println("Создание дебетового счета с балансом: " + balance);
            return new DebitAccount(id, balance, customer);
        }
    }



    @Override
    public void withdrawal(double money) throws AccountException {
        System.out.println("Снимаем деньги с дебетового счета.");
        if(isDeltaValid(money)) {
            double balance = getBalance() - money;
            if(balance>=0) {
                setBalance(balance);
                System.out.println("На счету " + balance);
            } else {
                throw new AccountException("Снятие такой суммы невозможно!");
            }

        }
    }

    @Override
    public void putMoney(double money) throws AccountException {
        System.out.println("Кладем деньги на дебетовый счет.");
        if(isDeltaValid(money)) {
            double balance = getBalance() + money;
            setBalance(balance);
            System.out.println("На счету " + balance);
        }
    }

}

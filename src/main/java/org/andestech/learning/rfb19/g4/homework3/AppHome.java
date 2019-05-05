package org.andestech.learning.rfb19.g4.homework3;

/**
 * Home work 3
 *
 */
public class AppHome
{
    public static void main( String[] args )
    {
        Customer customer1 = new Customer("Иван", "Иванов", "ул. Ленина, 32", 32, true);
        Customer customer2 = new Customer("Петр", "Петров", "ул. Коммунистическая, 8", 48, false);
        Customer customer3 = new Customer("Сидор", "Сидоров", "ул. Колхозная, 2", 17, true);
        Customer customer4 = new Customer("Модест", "Модестов", "ул. Пролетарская, 56", 78, false);

        DebitAccount dbAccount1, dbAccount2, dbAccount3;
        CreditAccount crAccount1, crAccount2, crAccount3, crAccount4, crAccount5, crAccount6;
        // init
        dbAccount1 = dbAccount2 = dbAccount3 = null;
        crAccount1 = crAccount2 = crAccount3 = crAccount4 = crAccount5 = crAccount6 = null;

        // дебетовый счет с нулевым остатком
        try {
            dbAccount1 = new DebitAccount(1, customer1);
        }
        catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // превышение верхнего лимита по дебетовому счету
        try {
            dbAccount2 = new DebitAccount(2, customer1, 100_000_000);
        }
        catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // создание дебетового счета с отрицательным остатком
        try {
            dbAccount3 = new DebitAccount(3, customer1, -1);
        } catch (DebitAccountException e) {
            System.out.println(e.getMessage());
        }

        // кредитовый счет
        try {
            crAccount1 = CreditAccount.createAccount(4, customer1, 10_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // плохая кредитная история
        try {
            crAccount2 = CreditAccount.createAccount(5, customer2, 10_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // возраст ниже требуемого
        try {
            crAccount3 = CreditAccount.createAccount(6, customer3, 10_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // возраст выше требуемого
        try {
            crAccount4 = CreditAccount.createAccount(7, customer4, 10_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // баланс ниже лимита
        try {
            crAccount5 = CreditAccount.createAccount(8, customer1, 100);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // баланс выше лимита
        try {
            crAccount6 = CreditAccount.createAccount(9, customer1, 100_000_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }


        // пополнение
        try {
            dbAccount1.putMoney(100);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // снятие
        try {
            dbAccount1.withdrawal(100);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // овердрафт
        try {
            dbAccount1.withdrawal(1);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // выше лимита
        try {
            dbAccount1.withdrawal(100_000_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }


        // пополнение
        try {
            crAccount1.putMoney(10_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // снятие
        try {
            crAccount1.withdrawal(10_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // овердрафт
        try {
            crAccount1.withdrawal(10_001);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // превышение лимита снятия
        try {
            crAccount1.putMoney(30_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        try {
            crAccount1.withdrawal(30_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // выше лимита
        try {
            crAccount1.putMoney(10_000_000);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(dbAccount1);
        System.out.println(dbAccount2);
        System.out.println(dbAccount3);

        System.out.println(crAccount1);
        System.out.println(crAccount2);
        System.out.println(crAccount3);
        System.out.println(crAccount4);
        System.out.println(crAccount5);
        System.out.println(crAccount6);
    }
}

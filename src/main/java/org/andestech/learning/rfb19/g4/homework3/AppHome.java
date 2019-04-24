// rename package
package org.andestech.learning.rfb19.g4.homework3;

/**
 * Home work 3
 *
 */
public class AppHome
{
    public static void main( String[] args ) throws CustomerException, AccountException, DebitAccountException, CreditAccountException {
        //задан клиент
        Customer client1 = new Customer("Иван", "Петров", "ул.Ленина, д.1", 20);
        Customer client2 = new Customer("Сергей", "Иванов", "ул.Ленина, д.2", 18);

        //открываем дебетовый счет с суммой 100 клиенту 1
        DebitAccount debit1 = new DebitAccount();
        debit1.debitAccount(1, 100, client1);

        //пополняем дебетовый счет клиенту 1
        debit1.putMoney(500);

        //снимает деньги с дебетового счета у клиента 1
        debit1.withdrawal(600);

        //----------------------------------------------------------------------
        //открываем кредитный счет с суммой 200 клиенту 2
        CreditAccount.createAccount(2, 90, client2);

        CreditAccount createAccount = CreditAccount.create();

        //снимаем деньги с кредитного счета у клиента 2
        createAccount.withdrawal(10000);

        //пополняем кредитный счет у клиента 2
        createAccount.putMoney(100);







    }
}

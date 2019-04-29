// rename package
package org.andestech.learning.rfb19.g4.homework3;

/**
 * Home work 3
 *
 */
public class AppHome{

    public static void main( String[] args ){

        try {
            Customer customer1 = new Customer("Alexander", "Baryshev", "Moscow", 18);
            System.out.println(CreditAccount.createAcc(true, customer1));
            System.out.println(CreditAccount.createAcc(false, customer1));
            Customer customer2 = new Customer("Vladimir", "Ivanov", "Voronezh", 17);
            System.out.println(CreditAccount.createAcc(true, customer2));
            Customer customer3 = new Customer("Ivan", "Popov", "Riga", 61);
            System.out.println(CreditAccount.createAcc(true, customer3));
            Customer customer4 = new Customer("Viktor", "North", "Petrovka", 25);
            CreditAccount crA4 = CreditAccount.createAcc(true, customer4);
            System.out.println(crA4);
            Customer customer5 = new Customer("Sergeii", "Bibikov", "Klin", 36);
            CreditAccount crA5 = CreditAccount.createAcc(true, customer5);
            System.out.println(crA5);

            System.out.println("------------------------Проверка дебетового счета-----------------------");
            DebitAccount debitAccount = new DebitAccount(customer1);
            System.out.println(debitAccount.putMoney(1000));
            System.out.println(debitAccount.putMoney(1000000));
            System.out.println(debitAccount.withdrawal(50));
            System.out.println(debitAccount.withdrawal(820));
            System.out.println(debitAccount.withdrawal(1));

            System.out.println("------------------------Проверка кредитного счета-----------------------");
            CreditAccount crA = CreditAccount.createAcc(true, customer1);
            System.out.println(crA.getBalance());
            System.out.println(crA.putMoney(10));
            System.out.println(crA.withdrawal(11));
            System.out.println(crA.putMoney(99940));
            System.out.println(crA.putMoney(1));

        } catch (CreditAccountException e) {
            System.out.println(e.getMessage());
        } catch (DebitAccountException e) {
           System.out.println (e.getMessage());
        }
    }
}

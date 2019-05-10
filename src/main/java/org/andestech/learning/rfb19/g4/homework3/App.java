package org.andestech.learning.rfb19.g4.homework3;

import org.andestech.learning.rfb19.g4.homework3.Exceptions.CreditAccountException;
import org.andestech.learning.rfb19.g4.homework3.Exceptions.DebitAccountException;


public class App 
{
    public static void main( String[] args ) throws CreditAccountException, DebitAccountException {

        Customer customer69 = new Customer("Vasyly", "Dulin", 50, "ul. Valovaya");
        DebitAccount customer69DebitAccount = new DebitAccount(1, customer69, 100);
        CreditAccount customer69CreditAccount = CreditAccount.createCreditAccount(true, customer69.getAge(), customer69, 1500, 1);

        try {
            CreditAccount.createCreditAccount(true,13, customer69,10,2);
        } catch (CreditAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(customer69DebitAccount.getBalance());
        System.out.println(customer69CreditAccount.getBalance());
        customer69CreditAccount.putMoney(10);
        System.out.println(customer69CreditAccount.getBalance());
        customer69CreditAccount.withdrawal(5);
        System.out.println(customer69CreditAccount.getBalance());

        try{
            customer69CreditAccount.withdrawal(1000.01);
        } catch (CreditAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(customer69DebitAccount.getBalance());

        try{
            customer69DebitAccount.putMoney(100_000.01);
        } catch (DebitAccountException e) {
            System.out.println(e.getMessage());
        }

        try {
            customer69DebitAccount.withdrawal(400);
        } catch (DebitAccountException e) {
            System.out.println(e.getMessage());
        }

    }
}

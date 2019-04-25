// rename package
package org.andestech.learning.rfb19.g4.homework3;

import org.andestech.learning.rfb19.g4.homework3.exception.CreditAccountException;
import org.andestech.learning.rfb19.g4.homework3.exception.DebitAccountException;

/**
 * Home work 3
 *
 */
public class AppHome
{
    public static void main( String[] args )
    {
        Customer validCustomer = new Customer("Elon", "Musk", 47, "LA");
        Customer invalidCustomer = new Customer("Elon", "Musk", 15, "LA");

        System.out.println("Create credit account:");
        Account valid = CreditAccount.createCreditAccount(1L, validCustomer);
        System.out.println(valid);
        System.out.println("----------------------------");
        try {
            Account invalid = CreditAccount.createCreditAccount(2L, invalidCustomer);
            System.out.println(invalid);
        }catch (CreditAccountException ex){
            ex.printStackTrace();
        }
        System.out.println("----------------------------");

        Account debitAccountValid = new DebitAccount(1L, validCustomer);
        System.out.println(debitAccountValid);
        try {
            debitAccountValid.withdrawal(100_000);
        }catch (DebitAccountException ex){
            ex.printStackTrace();
        }
        debitAccountValid.putMoney(100);
        System.out.println(debitAccountValid);


    }
}

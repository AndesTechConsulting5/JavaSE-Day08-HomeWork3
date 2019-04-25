// rename package
package org.andestech.learning.rfb19.g4.homework3;


/**
 * Home work 3
 *
 */
public class AppHome
{
    public static void main( String[] args ) throws DebitAccountException {

        Customer cus1 = new Customer("Vladimir", "Ovod", 19, "M", true );


        try { DebitAccount  dbAcc_1 = new DebitAccount(1, 40, cus1 );
        }
        catch (DebitAccountException e) {
            System.out.println("----");
            System.out.println( e.getMessage() );
        };


        CreditAccount crAcc_1 = CreditAccount.create(2, 10000, cus1 );

        crAcc_1.withdrawal( 100);
        crAcc_1.putMoney( 2000000);



    }
}

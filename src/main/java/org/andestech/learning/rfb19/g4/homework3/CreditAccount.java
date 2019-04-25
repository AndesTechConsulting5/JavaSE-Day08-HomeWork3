package org.andestech.learning.rfb19.g4.homework3;



    public class CreditAccount extends Account {

        private static final double MIN_AGE = 18;

        private static final double LIM_CRD_WDR = 400, LIM_CRD_REST = 10, LIM_CRD_EXC = 50000;


        // constructor

        private CreditAccount(int accountId, double balance, Customer customer) {
            super(accountId, balance, customer);
        }


        static CreditAccount create(int accountId, double balance, Customer customer)  {
            if (customer.getAge() > MIN_AGE && customer.isHistory()) {
                System.out.println("[INFO] [CREDIT] Creating  account");
                return new CreditAccount(accountId, balance, customer);
            } else {
                System.out.println("[ERROR] Age or credit history is not VALID for creating credit account");

                throw new CreditAccountException("---> EXCEPTION while creating CREDIT account");


            }
        }


        @Override
        public void withdrawal(double cash) {

            if ((cash < LIM_CRD_WDR) && (getBalance() - cash > LIM_CRD_REST) && ( cash > 0) ){

                setBalance(getBalance() - cash);
                System.out.println("[INFO] [CREDIT] withdrawal OK" + " balance setted to --> " + getBalance());
            } else {
                System.out.println("[ERROR] [CREDIT] withdrawal is not OK");
                throw new CreditAccountException("---> EXCEPTION [withdrawal] operation value is not allowed");
            }

        }

        @Override
        public void putMoney(double cash) {

            if ( (getBalance() + cash < LIM_CRD_EXC) && cash > 0 ) {

                setBalance(getBalance() + cash);
                System.out.println("[INFO] [CREDIT] putting is OK, your balance is " + getBalance());

            } else {
                System.out.println("[ERROR] [CREDIT] putting isn't OK, your balance is " + getBalance());
                throw new CreditAccountException("---> EXCEPTION [put money] operation value is not allowed");
            }

        }

    }

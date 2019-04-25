package org.andestech.learning.rfb19.g4.homework3;



    public abstract class Account {

        public Customer customer;
        public double balance;
        public int accountID;

        public abstract void withdrawal ( double cash );
        public abstract void putMoney   ( double cash );


        // constructor
        public Account ( int accountID, double balance, Customer customer ) {

            this.accountID = accountID;
            this.balance   = balance;
            this.customer  = customer;

        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }
    }


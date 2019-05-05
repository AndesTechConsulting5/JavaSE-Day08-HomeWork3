package org.andestech.learning.rfb19.g4.homework3;

enum AccountType {
    DebitAccount(0, 10_000_000, 30_000),
    CreditAccount(1_000, 1_000_000, 20_000);

    private double limitLow, limitHigh, limitWithdrawal;

    public double getLimitLow() {
        return limitLow;
    }

    public double getLimitHigh() {
        return limitHigh;
    }

    public double getLimitWithdrawal() {
        return limitWithdrawal;
    }

    AccountType(double limitLow, double limitHigh, double limitWithdrawal) {
        this.limitLow = limitLow;
        this.limitHigh = limitHigh;
        this.limitWithdrawal = limitWithdrawal;
    }
}

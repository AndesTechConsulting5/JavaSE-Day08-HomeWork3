package org.andestech.learning.rfb19.g4.homework3;

enum AccType {

    DebitAccount(0, 1_000_000, 100_000),
    CreditAccount(-10_000, 10_000, 1000);

    private double minLimit,
                   maxLimit,
                   accDelta;

    AccType(double minLimit, double maxLimit, double accDelta) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.accDelta = accDelta;
    }

    public double getMinLimit() {
        return minLimit;
    }

    public double getMaxLimit() {
        return maxLimit;
    }

    public double getAccDelta() {
        return accDelta;
    }
}

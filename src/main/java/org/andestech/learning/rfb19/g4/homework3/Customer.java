package org.andestech.learning.rfb19.g4.homework3;

public class Customer {

    private String firstName, secondName, address;
    private int age;
    private boolean isCreditHistoryGood;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCreditHistoryGood() {
        return isCreditHistoryGood;
    }

    public void setCreditHistoryGood(boolean creditHistoryGood) {
        isCreditHistoryGood = creditHistoryGood;
    }

    public Customer(String firstName, String secondName, String address, int age, boolean isCreditHistoryGood) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.age = age;
        this.isCreditHistoryGood = isCreditHistoryGood;
    }

    public Customer(String firstName, String secondName, String address, int age) {
        this(firstName, secondName, address, age, false);
    }

    public Customer(String firstName, String secondName, String address) {
        this(firstName, secondName, address, 0);
    }

    public Customer(String firstName, String secondName) {
        this(firstName, secondName, "");
    }

    @Override
    public String toString() {
        return String.format("{Customer: [%s, %s] age: [%d] isCreditHistoryGood: [%b] address: [%s]}", secondName, firstName, age, isCreditHistoryGood, address);
    }
}

package org.andestech.learning.rfb19.g4.homework3;

public class Customer {

    private String firstName, secondName, address;
    private int age;



    public Customer() {
    }

    public Customer(String firstName, String secondName, String address, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.age = age;
    }



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



}

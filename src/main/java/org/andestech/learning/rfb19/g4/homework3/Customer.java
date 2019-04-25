package org.andestech.learning.rfb19.g4.homework3;

public class Customer {

    private String firstName, secondName;
    private int age;
    private String address;
    private boolean history;


    // GETTER


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public boolean isHistory() {
        return history;
    }




    // ---------- SETTER
    public void setAge(int age) {
        this.age = age;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Customer(String firstName, String secondName, int age, String address, boolean history) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
        this.history = history;
    }



}

package com.airtribe.studentmanagement.entity;

public class Person {
    public String name;
    public int age;
    private String phoneNumber;
    private String emailId;

    public Person(String name, int age, String phoneNumber, String emailId) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

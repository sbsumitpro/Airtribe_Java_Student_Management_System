package com.airtribe.studentmanagement.entity;

public class Person {
    private static int nextId = 1;
    protected int id;
    protected String name;
    protected String phoneNumber;
    protected String emailId;

    public Person(String name, String emailId, String phoneNumber) {
        this.id = nextId++;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }
}

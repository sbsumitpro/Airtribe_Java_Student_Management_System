package com.airtribe.studentmanagement.entity;

import com.airtribe.studentmanagement.Interface.Searchable;

public class Student extends Person implements Searchable {
    protected String studentId;

    public Student(String name, String emailId, String phoneNumber, String studentId) {
        super(name, emailId, phoneNumber);
        this.studentId = studentId;
    }

    @Override
    public Boolean matches(String keyword){
        keyword = keyword.toLowerCase();
        return this.name.toLowerCase().contains(keyword) ||
                this.emailId.toLowerCase().contains(keyword) ||
                this.studentId.toLowerCase().contains(keyword);
    }

    public String getStudentId() {
        return studentId;
    }

    public void display(){
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email ID: " + emailId);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("--------------------------------");
    }
}

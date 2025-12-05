package com.airtribe.studentmanagement.entity;

public class Main {
    public static void main(String[] args){
        Student student = new Student("Sumit", 32, "9564283860", "sbsumitpro@gmail.com", Student.Course.Node_JS, 16, "Hyderabad", 7.5, 856);

        student.toString();
        System.out.println(student.name);
    }
}

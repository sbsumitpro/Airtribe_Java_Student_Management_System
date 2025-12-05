package com.airtribe.studentmanagement.entity;

public class Student extends Person{

    public enum Course{
        Node_JS,
        Java
    }

    Course course;
    int cohortNo;
    String currentCity;
    double yearOfExp;
    int totalXP;

    public Student(String name, int age, String phoneNumber, String emailId, Course course, int cohortNo, String currentCity, double yearOfExp, int totalXP) {
        super(name, age, phoneNumber, emailId);
        this.course = course;
        this.cohortNo = cohortNo;
        this.currentCity = currentCity;
        this.yearOfExp = yearOfExp;
        this.totalXP = totalXP;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", cohortNo=" + cohortNo +
                ", currentCity='" + currentCity + '\'' +
                ", yearOfExp=" + yearOfExp +
                ", totalXP=" + totalXP +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

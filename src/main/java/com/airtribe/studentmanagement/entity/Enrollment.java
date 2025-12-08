package com.airtribe.studentmanagement.entity;

import com.airtribe.studentmanagement.Interface.Gradable;

import java.time.LocalDate;

public class Enrollment implements Gradable {
    private String enrollmentId;
    private Student student;
    private Course course;
    private double grade;
    private LocalDate enrollmentDate;

    public Enrollment(String enrollmentId, Student student, Course course) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    @Override
    public double getGrade() {
        return grade;
    }

    @Override
    public void setGrade(double grade) {
        this.grade = grade;
    }
}

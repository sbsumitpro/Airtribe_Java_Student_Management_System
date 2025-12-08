package com.airtribe.studentmanagement.entity;

import java.time.LocalDate;

public class GraduateStudent extends Student{
    private String thesisTopic;
    private LocalDate graduationDate;

    public GraduateStudent(String name, String emailId, String phoneNumber, String studentId, String thesisTopic, LocalDate graduationDate) {
        super(name, emailId, phoneNumber, studentId);
        this.thesisTopic = thesisTopic;
        this.graduationDate = graduationDate;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }
}

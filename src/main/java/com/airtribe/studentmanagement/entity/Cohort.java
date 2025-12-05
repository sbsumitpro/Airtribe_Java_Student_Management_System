package com.airtribe.studentmanagement.entity;

import java.time.LocalDate;
import java.util.List;

public class Cohort {
    private String id;
    private String name;
    private List<Student> students;
    private LocalDate startDate;
    private LocalDate endDate;

    public Cohort(LocalDate startDate, List<Student> students, String name, String id) {
        this.startDate = startDate;
        this.students = students;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}


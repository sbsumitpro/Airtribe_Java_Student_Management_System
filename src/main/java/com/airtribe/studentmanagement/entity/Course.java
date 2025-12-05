package com.airtribe.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String id;
    private final String name;
    private String description;
    private CourseLanguage courseLanguage;
    private CourseMedium courseMedium;
    private List<Cohort> cohorts;

    public void setCohorts(List<Cohort> cohorts) {
        this.cohorts = cohorts;
    }

    public Course(String id, String name, String description, CourseLanguage courseLanguage, CourseMedium courseMedium) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseLanguage = courseLanguage;
        this.courseMedium = courseMedium;
        this.cohorts = new ArrayList<>();
    }

    public Course(String id, String name, String description, CourseLanguage courseLanguage, CourseMedium courseMedium, List<Cohort> cohorts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseLanguage = courseLanguage;
        this.courseMedium = courseMedium;
        this.cohorts = cohorts;
    }

    public void addCohortToCourse(Cohort cohort){
        this.cohorts.add(cohort);
    }

    public String getId() {
        return Id;
    }

    public CourseMedium getCourseMedium() {
        return courseMedium;
    }

    public CourseLanguage getCourseLanguage() {
        return courseLanguage;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<Cohort> getCohorts() {
        return cohorts;
    }
}


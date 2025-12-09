package com.airtribe.studentmanagement.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String courseId){
        super("Course not found with the ID : " + courseId);
    }
}

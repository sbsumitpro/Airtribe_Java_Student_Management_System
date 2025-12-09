package com.airtribe.studentmanagement.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String studentId){
        super("Student not found with ID: "+ studentId);
    }
}

package com.airtribe.studentmanagement.exception;

public class DuplicateStudentException extends RuntimeException{
    public DuplicateStudentException(String studentId){
        super("Student already exists with the ID: " + studentId);
    }
}

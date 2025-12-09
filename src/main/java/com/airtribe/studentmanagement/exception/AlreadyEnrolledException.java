package com.airtribe.studentmanagement.exception;

public class AlreadyEnrolledException extends RuntimeException{
    public AlreadyEnrolledException(String studentId, String courseId){
        super("Student with ID " + studentId + "is already enrolled with course with ID + " + courseId + ". Please use different credentials.");
    }
}

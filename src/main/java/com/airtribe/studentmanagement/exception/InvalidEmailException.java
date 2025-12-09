package com.airtribe.studentmanagement.exception;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String email){
        Super("Invalid email format: " + email);
    }
}

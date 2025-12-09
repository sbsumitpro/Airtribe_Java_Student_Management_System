package com.airtribe.studentmanagement.service;

import com.airtribe.studentmanagement.entity.Student;
import com.airtribe.studentmanagement.exception.DuplicateStudentException;
import com.airtribe.studentmanagement.exception.InvalidEmailException;
import com.airtribe.studentmanagement.exception.StudentNotFoundException;

import java.util.*;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    // Factory pattern
    public void addStudent(String name, String emailId, String phoneNumber, String studentId ){
        if(!isValidEmail(emailId)){
            throw new InvalidEmailException(emailId);
        }

        // check for duplicate student id
        if(students.containsKey(studentId)){
            throw new DuplicateStudentException(studentId);
        }

        Student student = new Student(name, emailId, phoneNumber, studentId);
        students.put(student.getStudentId(), student);
    }

    private boolean isValidEmail(String email){
        return email !=null && email.contains("@") && email.contains(".");
    }

    public Student removeStudent(String id){
        return students.remove(id);
    }

    public Student getStudent(String id){
        Student student =  students.get(id);
        if(student == null){
            throw new StudentNotFoundException(id);
        }
        return student;
    }

    public List<Student> search(String keyword){
        List<Student> result = new ArrayList<>();
        for(Student s:students.values()){
            if(s.matches(keyword))result.add(s);
        }
        return result;
    }

    public List<Student> getAllStudents(){
        return new ArrayList<>(students.values());
    }
}

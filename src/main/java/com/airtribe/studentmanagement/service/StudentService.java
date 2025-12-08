package com.airtribe.studentmanagement.service;

import com.airtribe.studentmanagement.entity.Student;

import java.util.*;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    // Factory pattern
    public Student addStudent(String name, String emailId, String phoneNumber, String studentId ){
        Student student = new Student(name, emailId, phoneNumber, studentId);
        students.put(student.getStudentId(), student);
        return student;
    }

    public Student removeStudent(String id){
        return students.remove(id);
    }

    public Student getStudent(String id){
        return students.get(id);
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

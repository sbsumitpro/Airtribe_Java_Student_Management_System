package com.airtribe.studentmanagement.service;

import com.airtribe.studentmanagement.entity.*;
import com.airtribe.studentmanagement.exception.AlreadyEnrolledException;

import java.time.LocalDate;
import java.util.*;

public class EnrollmentService {
    private final Map<String, Enrollment> enrollments = new HashMap<>();
    private long seq = 1;

    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enrolStudent(String studentId, String courseId){
        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseId);

        if(isAlreadyEnrolled(studentId, courseId)){
            throw new AlreadyEnrolledException(studentId, courseId);
        }
        String enrollmentId = "ENR"+seq++;
        Enrollment enrollment = new Enrollment(enrollmentId, student, course);
        enrollments.put(enrollmentId, enrollment);
    }

    private boolean isAlreadyEnrolled(String studentId, String courseId){
        for(Enrollment e: enrollments.values()){
            if(e.getStudent().getStudentId().equals(studentId) && e.getCourse().getId().equals(courseId)){
                return true;
            }
        }
        return false;
    }

    public void unenrolStudent(String enrollmentId){
        Enrollment enrollment = enrollments.remove(enrollmentId);
        if(enrollment == null){
            throw new IllegalArgumentException("Enrollment not found");
        }
    }

    public void assignGrade(String enrollmentId, double grade){
        Enrollment enrollment = enrollments.get(enrollmentId);
        if(enrollment == null){
            throw new IllegalArgumentException("Enrollment not found");
        }
        enrollment.setGrade(grade);
    }

    public List<Enrollment> getEnrollmentForStudent(String studentId){
        List<Enrollment> result = new ArrayList<>();
        for(Enrollment e: enrollments.values()){
            if(e.getStudent().getStudentId().equals(studentId)){
                result.add(e);
            }
        }
        return result;
    }

    public List<Enrollment> getEnrollmentForCourse(String courseId){
        List<Enrollment> result = new ArrayList<>();
        for(Enrollment e: enrollments.values()){
            if(e.getCourse().getId().equals(courseId)){
                result.add(e);
            }
        }
        return result;
    }

    public List<Enrollment> getAllEnrollments(){
        return new ArrayList<>(enrollments.values());
    }

    public List<Enrollment> getEnrollmentsByDate(LocalDate startDate, LocalDate endDate){
        List<Enrollment> result = new ArrayList<>();
        for(Enrollment e: enrollments.values()){
            if(e.getEnrollmentDate().isAfter(startDate) && e.getEnrollmentDate().isBefore(endDate)){
                result.add(e);
            }
        }
        return result;
    }
}

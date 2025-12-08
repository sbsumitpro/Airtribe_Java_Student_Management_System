package com.airtribe.studentmanagement;

import com.airtribe.studentmanagement.entity.*;
import com.airtribe.studentmanagement.service.*;
import static com.airtribe.studentmanagement.util.UtilityMethods.printMessage;
import static com.airtribe.studentmanagement.util.UtilityMethods.printLine;
import static com.airtribe.studentmanagement.config.DataConfig.STUDENT_DATA;
import static com.airtribe.studentmanagement.config.DataConfig.COURSE_DATA;
import static com.airtribe.studentmanagement.config.DataConfig.ENROLLMENT_DATA;

public class Main {

    public static void main(String[] args) {
        try {
            Main app = new Main();
            app.runApplication();
        } catch (Exception e) {
            printMessage("Application failed: " + e.getMessage());
        }
    }

    private void runApplication() {
        // Initialize services
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);
        
        // Setup data
        setupStudents(studentService);
        setupCourses(courseService);
        setupEnrollments(enrollmentService);
        
        // Display results
        displayResults(studentService, courseService, enrollmentService);
    }

    private void setupStudents(StudentService studentService) {
        printMessage("Setting up students...");
        for (String[] student : STUDENT_DATA) {
            studentService.addStudent(student[0], student[1], student[2], student[3]);
        }
        printMessage("✔️ Students created: " + STUDENT_DATA.length);
    }

    private void setupCourses(CourseService courseService) {
        printMessage("Setting up courses...");
        for (String[] course : COURSE_DATA) {
            courseService.addCourse(course[0], course[1], course[2]);
        }
        printMessage("✔️ Courses created: " + COURSE_DATA.length);
    }

    private void setupEnrollments(EnrollmentService enrollmentService) {
        printMessage("Setting up enrollments...");
        int enrollmentCount = 0;
        for (String[] enrollment : ENROLLMENT_DATA) {
            try {
                enrollmentService.enrolStudent(enrollment[0], enrollment[1]);
                enrollmentCount++;
            } catch (IllegalArgumentException e) {
                printMessage("⚠️ Failed to enroll: " + e.getMessage());
            }
        }
        printMessage("✔️ Enrollments created: " + enrollmentCount);
        printLine();
    }

    private void displayResults(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        displayEnrollments(enrollmentService);
        displayStudents(studentService);
        displayCourses(courseService);
        displayStatistics(studentService, courseService, enrollmentService);
    }

    private void displayEnrollments(EnrollmentService enrollmentService) {
        printMessage("ENROLLMENTS:");
        for (Enrollment e : enrollmentService.getAllEnrollments()) {
            String enrollmentInfo = String.format("%-15s | %-20s | %s", 
                e.getStudent().getName(), 
                e.getCourse().getName(), 
                e.getEnrollmentDate());
            printMessage(enrollmentInfo);
        }
        printLine();
    }

    private void displayStudents(StudentService studentService) {
        printMessage("STUDENTS:");
        studentService.getAllStudents().forEach(s -> 
            printMessage("• " + s.getName() + " (" + s.getStudentId() + ")")
        );
        printLine();
    }

    private void displayCourses(CourseService courseService) {
        printMessage("COURSES:");
        courseService.getAllCourse().forEach(c -> 
            printMessage("• " + c.getName() + " (" + c.getId() + ")")
        );
        printLine();
    }

    private void displayStatistics(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        printMessage(" STATISTICS:");
        printMessage("Total Students: " + studentService.getAllStudents().size());
        printMessage("Total Courses: " + courseService.getAllCourse().size());
        printMessage("Total Enrollments: " + enrollmentService.getAllEnrollments().size());
    }
}
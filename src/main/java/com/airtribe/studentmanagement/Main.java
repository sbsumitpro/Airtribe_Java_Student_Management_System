package com.airtribe.studentmanagement;

import com.airtribe.studentmanagement.entity.*;
import com.airtribe.studentmanagement.service.*;
import com.airtribe.studentmanagement.Driver.StudentDriver;
import com.airtribe.studentmanagement.Driver.CourseDriver;
import com.airtribe.studentmanagement.Driver.EnrollmentDriver;
import com.airtribe.studentmanagement.Driver.StatisticsDriver;

import java.util.Scanner;

import static com.airtribe.studentmanagement.util.UtilityMethods.printMessage;
import static com.airtribe.studentmanagement.util.UtilityMethods.printLine;
import static com.airtribe.studentmanagement.config.DataConfig.STUDENT_DATA;
import static com.airtribe.studentmanagement.config.DataConfig.COURSE_DATA;
import static com.airtribe.studentmanagement.config.DataConfig.ENROLLMENT_DATA;

public class Main {
    private StudentService studentService;
    private CourseService courseService;
    private EnrollmentService enrollmentService;
    private Scanner scanner;
    
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
        studentService = new StudentService();
        courseService = new CourseService();
        enrollmentService = new EnrollmentService(studentService, courseService);
        scanner = new Scanner(System.in);
        
        // Setup data
        setupStudents(studentService);
        setupCourses(courseService);
        setupEnrollments(enrollmentService);
        
        showMainMenu();

        scanner.close();
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

    private void showMainMenu() {
        while (true) {
            printMessage("\n🎓 === STUDENT MANAGEMENT SYSTEM ===");
            printMessage("1. 👥 Student Management");
            printMessage("2. 📚 Course Management");
            printMessage("3. 📝 Enrollment Management");
            printMessage("4. 📊 Statistics & Reports");
            printMessage("5. 🚪 Exit");
            printMessage("Choose an option (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> {
                        StudentDriver studentDriver = new StudentDriver(studentService, scanner);
                        studentDriver.showStudentMenu();
                    }
                    case 2 -> {
                        CourseDriver courseDriver = new CourseDriver(courseService, scanner);
                        courseDriver.showCourseMenu();
                    }
                    case 3 -> {
                        EnrollmentDriver enrollmentDriver = new EnrollmentDriver(
                                enrollmentService, scanner);
                        enrollmentDriver.showEnrollmentMenu();
                    }
                    case 4 -> {
                        StatisticsDriver statisticsDriver = new StatisticsDriver(
                                studentService, courseService, enrollmentService, scanner);
                        statisticsDriver.showStatisticsMenu();
                    }
                    case 5 -> {
                        printMessage("👋 Thank you for using Student Management System!");
                        return;
                    }
                    default -> printMessage("❌ Invalid choice. Please select 1-5.");
                }
            } catch (Exception e) {
                printMessage("❌ Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }


}
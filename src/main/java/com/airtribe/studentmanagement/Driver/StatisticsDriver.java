package com.airtribe.studentmanagement.Driver;

import com.airtribe.studentmanagement.service.*;
import java.util.Scanner;

import static com.airtribe.studentmanagement.util.UtilityMethods.*;

public class StatisticsDriver {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final Scanner scanner;

    public StatisticsDriver(StudentService studentService, 
                           CourseService courseService, 
                           EnrollmentService enrollmentService, 
                           Scanner scanner) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
        this.scanner = scanner;
    }

    public void showStatisticsMenu() {
        while (true) {
            printMessage("\n=== STATISTICS & REPORTS ===");
            printMessage("1. General Statistics");
            printMessage("5. Back to Main Menu");
            printMessage("Choose an option (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> displayGeneralStatistics();
                    case 5 -> { return; }
                    default -> printMessage("Invalid choice. Please select 1-5.");
                }
            } catch (Exception e) {
                printMessage("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void displayGeneralStatistics() {
        printMessage("\n📊 GENERAL STATISTICS:");
        printLine();
        printMessage("📚 Total Students: " + studentService.getAllStudents().size());
        printMessage("📖 Total Courses: " + courseService.getAllCourse().size());
        printMessage("📝 Total Enrollments: " + enrollmentService.getAllEnrollments().size());
        printLine();
    }

    // Add other statistics methods similar to what I showed earlier...
    // (displayStudentStatistics, displayCourseStatistics, displayEnrollmentStatistics)
}
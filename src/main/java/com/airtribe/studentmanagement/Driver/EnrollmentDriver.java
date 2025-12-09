package com.airtribe.studentmanagement.Driver;

import com.airtribe.studentmanagement.entity.Enrollment;
import com.airtribe.studentmanagement.service.*;
import java.util.Scanner;

import static com.airtribe.studentmanagement.util.UtilityMethods.*;

public class EnrollmentDriver {
    private final EnrollmentService enrollmentService;
    private final Scanner scanner;

    public EnrollmentDriver(EnrollmentService enrollmentService,
                           Scanner scanner) {
        this.enrollmentService = enrollmentService;
        this.scanner = scanner;
    }

    public void showEnrollmentMenu() {
        while (true) {
            printMessage("\n=== ENROLLMENT MANAGEMENT ===");
            printMessage("1. View All Enrollments");
            printMessage("2. Enroll Student in Course");
            printMessage("3. Unenroll Student");
            printMessage("4. Assign Grade");
            printMessage("5. View Student Enrollments");
            printMessage("6. View Course Enrollments");
            printMessage("7. Back to Main Menu");
            printMessage("Choose an option (1-7): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> displayAllEnrollments();
                    case 2 -> enrollStudent();
                    case 3 -> unenrollStudent();
                    case 4 -> assignGrade();
                    case 5 -> viewStudentEnrollments();
                    case 6 -> viewCourseEnrollments();
                    case 7 -> { return; }
                    default -> printMessage("Invalid choice. Please select 1-7.");
                }
            } catch (Exception e) {
                printMessage("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void displayAllEnrollments() {
        printMessage("\n📝 ALL ENROLLMENTS:");
        printLine();
        printMessage(String.format("| %-12s | %-20s | %-25s | %-12s | %-6s |", 
            "Enroll ID", "Student Name", "Course Name", "Date", "Grade"));
        printLine();
        
        enrollmentService.getAllEnrollments().forEach(enrollment -> 
            printMessage(String.format("| %-12s | %-20s | %-25s | %-12s | %-6.1f |",
                enrollment.getEnrollmentId(),
                enrollment.getStudent().getName(),
                enrollment.getCourse().getName(),
                enrollment.getEnrollmentDate().toString(),
                enrollment.getGrade()))
        );
        printLine();
        printMessage("Total Enrollments: " + enrollmentService.getAllEnrollments().size());
    }

    private void enrollStudent() {
        try {
            printMessage("\n➕ ENROLL STUDENT:");
            
            printMessage("Enter student ID: ");
            String studentId = scanner.nextLine().trim();
            
            printMessage("Enter course ID: ");
            String courseId = scanner.nextLine().trim();
            
            enrollmentService.enrolStudent(studentId, courseId);
            printMessage("✅ Student enrolled successfully!");
            
        } catch (Exception e) {
            printMessage("❌ Failed to enroll student: " + e.getMessage());
        }
    }

    private void unenrollStudent() {
        try {
            printMessage("\n➖ UNENROLL STUDENT:");
            printMessage("Enter enrollment ID: ");
            String enrollmentId = scanner.nextLine().trim();
            
            enrollmentService.unenrolStudent(enrollmentId);
            printMessage("✅ Student unenrolled successfully!");
            
        } catch (Exception e) {
            printMessage("❌ Failed to unenroll student: " + e.getMessage());
        }
    }

    private void assignGrade() {
        try {
            printMessage("\n📊 ASSIGN GRADE:");
            
            printMessage("Enter enrollment ID: ");
            String enrollmentId = scanner.nextLine().trim();
            
            printMessage("Enter grade (0-100): ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            
            if (grade < 0 || grade > 100) {
                printMessage("❌ Grade must be between 0 and 100.");
                return;
            }
            
            enrollmentService.assignGrade(enrollmentId, grade);
            printMessage("✅ Grade assigned successfully!");
            
        } catch (Exception e) {
            printMessage("❌ Failed to assign grade: " + e.getMessage());
        }
    }

    private void viewStudentEnrollments() {
        try {
            printMessage("\n👤 STUDENT ENROLLMENTS:");
            printMessage("Enter student ID: ");
            String studentId = scanner.nextLine().trim();
            
            var enrollments = enrollmentService.getEnrollmentForStudent(studentId);
            
            if (enrollments.isEmpty()) {
                printMessage("❌ No enrollments found for student ID: " + studentId);
            } else {
                printMessage("\n✅ Enrollments for student " + studentId + ":");
                printLine();
                printMessage(String.format("| %-12s | %-25s | %-12s | %-6s |", 
                    "Enroll ID", "Course Name", "Date", "Grade"));
                printLine();
                
                enrollments.forEach(enrollment -> 
                    printMessage(String.format("| %-12s | %-25s | %-12s | %-6.1f |",
                        enrollment.getEnrollmentId(),
                        enrollment.getCourse().getName(),
                        enrollment.getEnrollmentDate().toString(),
                        enrollment.getGrade()))
                );
                printLine();
            }
        } catch (Exception e) {
            printMessage("❌ Error retrieving enrollments: " + e.getMessage());
        }
    }

    private void viewCourseEnrollments() {
        try {
            printMessage("\n📚 COURSE ENROLLMENTS:");
            printMessage("Enter course ID: ");
            String courseId = scanner.nextLine().trim();
            
            var enrollments = enrollmentService.getEnrollmentForCourse(courseId);
            
            if (enrollments.isEmpty()) {
                printMessage("❌ No enrollments found for course ID: " + courseId);
            } else {
                printMessage("\n✅ Enrollments for course " + courseId + ":");
                printLine();
                printMessage(String.format("| %-12s | %-20s | %-12s | %-6s |", 
                    "Enroll ID", "Student Name", "Date", "Grade"));
                printLine();
                
                enrollments.forEach(enrollment -> 
                    printMessage(String.format("| %-12s | %-20s | %-12s | %-6.1f |",
                        enrollment.getEnrollmentId(),
                        enrollment.getStudent().getName(),
                        enrollment.getEnrollmentDate().toString(),
                        enrollment.getGrade()))
                );
                printLine();
            }
        } catch (Exception e) {
            printMessage("❌ Error retrieving enrollments: " + e.getMessage());
        }
    }
}
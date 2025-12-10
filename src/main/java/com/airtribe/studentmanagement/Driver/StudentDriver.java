package com.airtribe.studentmanagement.Driver;

import com.airtribe.studentmanagement.entity.Student;
import com.airtribe.studentmanagement.service.EnrollmentService;
import com.airtribe.studentmanagement.service.StudentService;
import java.util.Scanner;

import static com.airtribe.studentmanagement.util.UtilityMethods.*;

public class StudentDriver {
    private final StudentService studentService;
    private final EnrollmentService enrollmentService;
    private final Scanner scanner;

    public StudentDriver(StudentService studentService, Scanner scanner, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.scanner = scanner;
        this.enrollmentService = enrollmentService;
    }

    public void showStudentMenu() {
        while (true) {
            printMessage("\n=== STUDENT MANAGEMENT ===");
            printMessage("1. View All Students");
            printMessage("2. Add New Student");
            printMessage("3. Search Students");
            printMessage("4. Remove Student");
            printMessage("5. Back to Main Menu");
            printMessage("Choose an option (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> displayAllStudents();
                    case 2 -> addNewStudent();
                    case 3 -> searchStudents();
                    case 4 -> removeStudent();
                    case 5 -> { return; }
                    default -> printMessage("Invalid choice. Please select 1-5.");
                }
            } catch (Exception e) {
                printMessage("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void displayAllStudents() {
        printMessage("\n📚 ALL STUDENTS:");
        printLine();
        printMessage(String.format("| %-15s | %-25s | %-25s | %-15s |", 
            "Student ID", "Name", "Email", "Phone"));
        printLine();
        
        studentService.getAllStudents().forEach(student -> 
            printMessage(String.format("| %-15s | %-25s | %-25s | %-15s |",
                student.getStudentId(),
                student.getName(),
                student.getEmailId(),
                student.getPhoneNumber()))
        );
        printLine();
        printMessage("Total Students: " + studentService.getAllStudents().size());
    }

    private void addNewStudent() {
        try {
            printMessage("\n➕ ADD NEW STUDENT:");
            
            printMessage("Enter student name: ");
            String name = scanner.nextLine().trim();
            
            printMessage("Enter email: ");
            String email = scanner.nextLine().trim();
            
            printMessage("Enter phone number: ");
            String phone = scanner.nextLine().trim();
            
            printMessage("Enter student ID: ");
            String studentId = scanner.nextLine().trim();
            
            studentService.addStudent(name, email, phone, studentId);
            printMessage("✅ Student added successfully!");
            
        } catch (Exception e) {
            printMessage("❌ Failed to add student: " + e.getMessage());
        }
    }

    private void searchStudents() {
        printMessage("\n🔍 STUDENT SEARCH:");
        printMessage("Enter search keyword (name, email, or student ID): ");
        String keyword = scanner.nextLine().trim();
        
        if (keyword.isEmpty()) {
            printMessage("❌ Search keyword cannot be empty.");
            return;
        }
        
        var results = studentService.search(keyword);
        
        if (results.isEmpty()) {
            printMessage("❌ No students found matching '" + keyword + "'");
        } else {
            printMessage("\n✅ Found " + results.size() + " student(s):");
            printLine();
            printMessage(String.format("| %-15s | %-25s | %-25s |", 
                "Student ID", "Name", "Email"));
            printLine();
            
            results.forEach(student -> 
                printMessage(String.format("| %-15s | %-25s | %-25s |",
                    student.getStudentId(),
                    student.getName(),
                    student.getEmailId()))
            );
            printLine();
        }
    }

    private void removeStudent() {
        try {
            printMessage("\n➖ REMOVE STUDENT:");
            printMessage("Enter student ID to remove: ");
            String studentId = scanner.nextLine().trim();
            
            Student removed = studentService.removeStudent(studentId, enrollmentService);
            if (removed != null) {
                printMessage("✅ Student removed: " + removed.getName());
            } else {
                printMessage("❌ Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            printMessage("❌ Error removing student: " + e.getMessage());
        }
    }
}
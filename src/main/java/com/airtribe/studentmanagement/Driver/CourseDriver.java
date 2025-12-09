package com.airtribe.studentmanagement.Driver;

import com.airtribe.studentmanagement.entity.Course;
import com.airtribe.studentmanagement.service.CourseService;
import java.util.Scanner;

import static com.airtribe.studentmanagement.util.UtilityMethods.*;

public class CourseDriver {
    private final CourseService courseService;
    private final Scanner scanner;

    public CourseDriver(CourseService courseService, Scanner scanner) {
        this.courseService = courseService;
        this.scanner = scanner;
    }

    public void showCourseMenu() {
        while (true) {
            printMessage("\n=== COURSE MANAGEMENT ===");
            printMessage("1. View All Courses");
            printMessage("2. Add New Course");
            printMessage("3. Search Courses");
            printMessage("4. Remove Course");
            printMessage("5. Back to Main Menu");
            printMessage("Choose an option (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> displayAllCourses();
                    case 2 -> addNewCourse();
                    case 3 -> searchCourses();
                    case 4 -> removeCourse();
                    case 5 -> { return; }
                    default -> printMessage("Invalid choice. Please select 1-5.");
                }
            } catch (Exception e) {
                printMessage("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void displayAllCourses() {
        printMessage("\n📖 ALL COURSES:");
        printLine();
        printMessage(String.format("| %-12s | %-30s | %-50s |", 
            "Course ID", "Course Name", "Description"));
        printLine();
        
        courseService.getAllCourse().forEach(course -> 
            printMessage(String.format("| %-12s | %-30s | %-50s |",
                course.getId(),
                course.getName(),
                course.getDescription().length() > 47 ? 
                    course.getDescription().substring(0, 47) + "..." : 
                    course.getDescription()))
        );
        printLine();
        printMessage("Total Courses: " + courseService.getAllCourse().size());
    }

    private void addNewCourse() {
        try {
            printMessage("\n➕ ADD NEW COURSE:");
            
            printMessage("Enter course ID: ");
            String courseId = scanner.nextLine().trim();
            
            printMessage("Enter course name: ");
            String name = scanner.nextLine().trim();
            
            printMessage("Enter course description: ");
            String description = scanner.nextLine().trim();
            
            courseService.addCourse(courseId, name, description);
            printMessage("✅ Course added successfully!");
            
        } catch (Exception e) {
            printMessage("❌ Failed to add course: " + e.getMessage());
        }
    }

    private void searchCourses() {
        printMessage("\n🔍 COURSE SEARCH:");
        printMessage("Enter search keyword (course name, ID, or description): ");
        String keyword = scanner.nextLine().trim();
        
        if (keyword.isEmpty()) {
            printMessage("❌ Search keyword cannot be empty.");
            return;
        }
        
        var results = courseService.search(keyword);
        
        if (results.isEmpty()) {
            printMessage("❌ No courses found matching '" + keyword + "'");
        } else {
            printMessage("\n✅ Found " + results.size() + " course(s):");
            printLine();
            printMessage(String.format("| %-12s | %-30s | %-40s |", 
                "Course ID", "Course Name", "Description"));
            printLine();
            
            results.forEach(course -> 
                printMessage(String.format("| %-12s | %-30s | %-40s |",
                    course.getId(),
                    course.getName(),
                    course.getDescription().length() > 37 ? 
                        course.getDescription().substring(0, 37) + "..." : 
                        course.getDescription()))
            );
            printLine();
        }
    }

    private void removeCourse() {
        try {
            printMessage("\n➖ REMOVE COURSE:");
            printMessage("Enter course ID to remove: ");
            String courseId = scanner.nextLine().trim();
            
            Course removed = courseService.removeCourse(courseId);
            if (removed != null) {
                printMessage("✅ Course removed: " + removed.getName());
            } else {
                printMessage("❌ Course not found with ID: " + courseId);
            }
        } catch (Exception e) {
            printMessage("❌ Error removing course: " + e.getMessage());
        }
    }
}
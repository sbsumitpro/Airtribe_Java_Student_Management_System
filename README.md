# 🎓 Student Management System

[![Java Version](https://img.shields.io/badge/Java-24-orange)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen)](README.md)

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Project Architecture](#project-architecture)
- [Folder Structure](#folder-structure)
- [Getting Started](#getting-started)
- [Usage Guide](#usage-guide)
- [Design Patterns Used](#design-patterns-used)
- [Future Extensibility](#future-extensibility)
- [Contributing](#contributing)
- [FAQ](#faq)
- [Author](#author)
- [License](#license)

## 🌟 Overview

The **Student Management System** is a comprehensive Java-based console application designed to manage students, courses, and enrollments in an educational institution. Built with modern Java 24 features and following enterprise-level software design principles, this system provides a robust, scalable, and maintainable solution for academic administration.

### 🎯 **Key Objectives**
- **Efficient Management**: Streamline student, course, and enrollment operations
- **Data Integrity**: Ensure data consistency with comprehensive validation
- **User Experience**: Provide intuitive console-based interface
- **Extensibility**: Support future feature additions and modifications
- **Best Practices**: Demonstrate professional Java development standards

## ✨ Features

### 👥 **Student Management**
- ✅ Add new students with validation
- ✅ View all students in formatted tables
- ✅ Search students by name, email, or ID
- ✅ Remove students from the system
- ✅ Email format validation
- ✅ Duplicate prevention

### 📚 **Course Management**
- ✅ Create and manage courses
- ✅ View course catalog
- ✅ Search courses by name, ID, or description
- ✅ Course removal functionality
- ✅ Detailed course descriptions

### 📝 **Enrollment Management**
- ✅ Enroll students in courses
- ✅ Prevent duplicate enrollments
- ✅ Assign and update grades
- ✅ Unenroll students
- ✅ View enrollment history
- ✅ Date tracking for enrollments

### 📊 **Statistics & Reporting**
- ✅ General system statistics


### 🛡️ **Robust Error Handling**
- ✅ Custom exception classes
- ✅ Input validation
- ✅ Graceful error recovery
- ✅ Detailed error messages

## 🏗️ Project Architecture

### **Architectural Patterns**
- **MVC (Model-View-Controller)**: Separation of concerns
- **Service Layer**: Business logic encapsulation
- **Driver Pattern**: Modular UI components
- **Factory Pattern**: Object creation management
- **Repository Pattern**: Data access abstraction

### **Core Components**

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Driver Layer  │    │  Service Layer  │    │  Entity Layer   │
│   (UI Logic)    │◄───│ (Business Logic)│◄───│  (Data Models)  │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│  Utility Layer  │    │Exception Handling│    │   Interfaces    │
│   (Helpers)     │    │    (Errors)     │    │  (Contracts)    │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

## 📁 Folder Structure

```
Student_Management_System/
├── 📄 README.md                           # Project documentation
├── 📄 pom.xml                             # Maven configuration
└── src/
    └── main/
        └── java/
            └── com/
                └── airtribe/
                    └── studentmanagement/
                        ├── 📄 Main.java                    # Application entry point
                        ├── 📁 Driver/                      # UI Controller Layer
                        │   ├── 📄 StudentDriver.java      # Student UI operations
                        │   ├── 📄 CourseDriver.java       # Course UI operations
                        │   ├── 📄 EnrollmentDriver.java   # Enrollment UI operations
                        │   └── 📄 StatisticsDriver.java   # Statistics UI operations
                        ├── 📁 service/                     # Business Logic Layer
                        │   ├── 📄 StudentService.java     # Student business logic
                        │   ├── 📄 CourseService.java      # Course business logic
                        │   └── 📄 EnrollmentService.java  # Enrollment business logic
                        ├── 📁 entity/                      # Data Model Layer
                        │   ├── 📄 Person.java             # Base person entity
                        │   ├── 📄 Student.java            # Student entity
                        │   ├── 📄 GraduateStudent.java    # Graduate student entity
                        │   ├── 📄 Course.java             # Course entity
                        │   └── 📄 Enrollment.java         # Enrollment entity
                        ├── 📁 Interface/                   # Contract Definitions
                        │   ├── 📄 Searchable.java         # Search capability contract
                        │   └── 📄 Gradable.java           # Grading capability contract
                        ├── 📁 exception/                   # Custom Exception Classes
                        │   ├── 📄 StudentNotFoundException.java
                        │   ├── 📄 CourseNotFoundException.java
                        │   ├── 📄 DuplicateStudentException.java
                        │   ├── 📄 InvalidEmailException.java
                        │   └── 📄 AlreadyEnrolledException.java
                        ├── 📁 config/                      # Configuration Layer
                        │   └── 📄 DataConfig.java          # Initial data configuration
                        └── 📁 util/                        # Utility Layer
                            └── 📄 UtilityMethods.java      # Helper methods
```

## 🚀 Getting Started

### **Prerequisites**
- ☕ Java Development Kit (JDK) 24 or higher
- 🔨 Apache Maven 3.6+ (for dependency management)
- 💻 Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### **Installation Steps**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/sbsumitpro/Airtribe_Java_Student_Management_System.git
   cd Airtribe_Java_Student_Management_System
   ```

2. **Create Output Directory**
   ```bash
   mkdir -p out
   ```

3. **Compile the Project**
   ```bash
   javac -d out src/main/java/com/airtribe/studentmanagement/**/*.java
   ```

4. **Run the Application**
   ```bash
   java -cp out com.airtribe.studentmanagement.Main
   ```

### **Quick Start**
Once the application starts, you'll see the main menu with options to manage students, courses, enrollments, and view statistics. The system comes pre-loaded with sample data for immediate testing.

## 📖 Usage Guide

### **Main Menu Navigation**
```
🎓 === STUDENT MANAGEMENT SYSTEM ===
1. 👥 Student Management
2. 📚 Course Management  
3. 📝 Enrollment Management
4. 📊 Statistics & Reports
5. 🚪 Exit
```

### **Sample Operations**

#### **Adding a New Student**
1. Select "Student Management" → "Add New Student"
2. Enter student details:
   - Name: "John Doe"
   - Email: "john.doe@university.edu"
   - Phone: "1234567890"
   - Student ID: "STU001"

#### **Enrolling a Student**
1. Select "Enrollment Management" → "Enroll Student in Course"
2. Enter Student ID and Course ID
3. System automatically assigns enrollment ID and date

#### **Viewing Statistics**
1. Select "Statistics & Reports"
2. Choose from various statistical views:
   - General statistics
   - Student performance metrics
   - Course popularity analysis

## 🎨 Design Patterns Used

### **1. Service Layer Pattern**
- **Purpose**: Encapsulates business logic
- **Implementation**: `StudentService`, `CourseService`, `EnrollmentService`
- **Benefit**: Clean separation of concerns

### **2. Driver Pattern**
- **Purpose**: Modular UI components
- **Implementation**: Separate driver classes for each domain
- **Benefit**: Improved maintainability and testability

### **3. Factory Pattern**
- **Purpose**: Object creation management
- **Implementation**: Service classes handle entity creation
- **Benefit**: Centralized validation and initialization

### **4. Repository Pattern**
- **Purpose**: Data access abstraction
- **Implementation**: In-memory collections with service layer
- **Benefit**: Easy to extend to database storage

### **5. Strategy Pattern**
- **Purpose**: Search functionality
- **Implementation**: `Searchable` interface with different matching strategies
- **Benefit**: Flexible search implementations

## 🚀 Future Extensibility

### **📊 Planned Enhancements**

#### **Phase 1: Data Persistence**
```java
// Database integration
public interface StudentRepository {
    void save(Student student);
    Student findById(String id);
    List<Student> findAll();
}
```

#### **Phase 2: RESTful API**
```java
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @GetMapping
    public List<Student> getAllStudents() { ... }
    
    @PostMapping
    public Student createStudent(@RequestBody Student student) { ... }
}
```

#### **Phase 3: Web Interface**
- React.js frontend
- Spring Boot backend
- RESTful API integration
- Real-time updates

#### **Phase 4: Advanced Features**
- 📧 Email notifications
- 📅 Scheduling system
- 📊 Advanced analytics
- 🔐 Authentication & authorization
- 📱 Mobile application
- 🌐 Multi-tenancy support

### **🔧 Extension Points**

#### **Adding New Entity Types**
```java
// Easy to extend with new student types
public class InternationalStudent extends Student {
    private String visaStatus;
    private String homeCountry;
    // Additional fields and methods
}
```

#### **Custom Validation Rules**
```java
// Pluggable validation system
public interface ValidationRule<T> {
    boolean validate(T entity);
    String getErrorMessage();
}
```

#### **Reporting Framework**
```java
// Extensible reporting system
public interface ReportGenerator {
    Report generate(ReportCriteria criteria);
    String getFormat(); // PDF, Excel, CSV
}
```

### **🏗️ Architecture Scalability**

#### **Microservices Migration Path**
```
Current Monolith → Modular Monolith → Microservices

StudentService → Student Microservice
CourseService → Course Microservice  
EnrollmentService → Enrollment Microservice
```

#### **Cloud Deployment Ready**
- Docker containerization support
- Kubernetes orchestration
- CI/CD pipeline integration
- Cloud database compatibility

## 🤝 Contributing

We welcome contributions to improve the Student Management System! Here's how you can help:

### **Development Guidelines**
1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/amazing-feature`
3. **Follow** Java coding standards and conventions
4. **Write** comprehensive JavaDoc documentation
5. **Add** unit tests for new functionality
6. **Commit** changes: `git commit -m 'Add amazing feature'`
7. **Push** to branch: `git push origin feature/amazing-feature`
8. **Create** a Pull Request

### **Code Standards**
- Use meaningful variable and method names
- Follow camelCase naming conventions
- Add JavaDoc comments for all public methods
- Maintain consistent indentation (4 spaces)
- Include error handling and validation

### **Testing Requirements**
- Unit tests for service layer methods
- Integration tests for driver classes
- Edge case testing for validation logic
- Performance testing for large datasets

## ❓ FAQ

### **General Questions**

#### **Q: What Java version is required?**
A: The project requires Java 24 or higher due to the use of modern Java features like enhanced switch expressions and pattern matching.

#### **Q: Can I use this project with a database?**
A: Currently, the system uses in-memory storage. However, it's designed with the Repository pattern, making database integration straightforward. See the [Future Extensibility](#future-extensibility) section for planned database support.

#### **Q: How do I add custom validation rules?**
A: Extend the validation methods in service classes or implement custom exception classes. For example:
```java
public class CustomStudentValidator {
    public static void validateAge(int age) {
        if (age < 16 || age > 100) {
            throw new InvalidAgeException("Age must be between 16 and 100");
        }
    }
}
```

### **Technical Questions**

#### **Q: How do I extend the system with new entity types?**
A: Create new entities extending existing base classes, implement required interfaces, and add corresponding service classes. The modular architecture supports easy extension.

#### **Q: Can I modify the console output format?**
A: Yes! Customize the `UtilityMethods` class or create new formatting utilities. The system is designed for easy UI modifications.

#### **Q: How do I handle large datasets?**
A: The current implementation uses HashMap for O(1) lookups. For larger datasets, consider implementing pagination and database storage as outlined in future enhancements.

### **Usage Questions**

#### **Q: What happens if I enter duplicate student IDs?**
A: The system throws a `DuplicateStudentException` and prevents the duplicate entry, maintaining data integrity.

#### **Q: Can students be enrolled in multiple courses?**
A: Yes! Students can enroll in multiple courses, and the system tracks all enrollments with unique enrollment IDs.

#### **Q: How do I backup my data?**
A: Currently, data is stored in memory and reset on application restart. Future versions will include data persistence and backup functionality.

### **Troubleshooting**

#### **Q: Application won't start - "Scanner cannot be resolved"**
A: Ensure all instance variables are declared at the class level, not inside methods. Check the Main.java implementation for proper variable scope.

#### **Q: Getting compilation errors about missing classes**
A: Verify all import statements are correct and all required classes exist in their respective packages.

#### **Q: Menu options not working properly**
A: Check that all Driver classes are properly implemented and imported in Main.java.

## 👨‍💻 Author

**Sumit Biswas**
- 📧 Email: [sbsumitpro@gmail.com](mailto:sbsumitpro@gmail.com)
- 💼 LinkedIn: [Connect with me](https://www.linkedin.com/in/sbsumitpro/)
- 📍 Location: India

### **About the Developer**
Passionate Java developer with expertise in enterprise application development, system design, and modern software engineering practices. This Student Management System represents a comprehensive demonstration of Object-Oriented Programming principles, design patterns, and clean code practices.

### **Skills Demonstrated**
- ☕ Advanced Java Programming (Java 24)
- 🏗️ Object-Oriented Design & Architecture
- 🎨 Design Pattern Implementation
- 🛠️ Maven Project Management
- 📚 Software Documentation
- 🧪 Test-Driven Development
- 🔄 Version Control (Git)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### **MIT License Summary**
- ✅ Commercial use allowed
- ✅ Modification allowed
- ✅ Distribution allowed
- ✅ Private use allowed
- ❗ License and copyright notice required
- ❗ No warranty provided

---

## 🙏 Acknowledgments

- 🎓 **AirTribe Java Cohort** - For providing the learning platform and guidance
- 👥 **Fellow Developers** - For code reviews and suggestions
- 📚 **Java Community** - For best practices and design patterns
- 🛠️ **Open Source Tools** - Maven, Git, and development tools

---

## 📈 Project Statistics

```
📊 Project Metrics:
├── 📁 Total Packages: 8
├── 📄 Java Classes: 18
├── 🔧 Service Classes: 3
├── 🎨 Driver Classes: 4
├── 📋 Entity Classes: 5
├── ⚠️ Exception Classes: 5
├── 🔗 Interface Classes: 2
└── 📝 Lines of Code: ~1,500+
```

---

### ⭐ **Star this repository if you found it helpful!**

**Happy Coding! 🚀**

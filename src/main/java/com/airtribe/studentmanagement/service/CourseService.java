package com.airtribe.studentmanagement.service;

import com.airtribe.studentmanagement.entity.Course;
import com.airtribe.studentmanagement.exception.CourseNotFoundException;

import java.util.*;

public class CourseService {
    private final Map<String, Course> courses = new HashMap<>();
    // Factory pattern
    public Course addCourse(String id, String name, String description){
        Course course = new Course(id, name, description);
        courses.put(course.getId(), course);
        return course;
    }

    public Course removeCourse(String id, EnrollmentService enrollmentService){
        Course course = courses.remove(id);
        if(course == null){
            throw new CourseNotFoundException(id);
        }
        enrollmentService.removeEnrollmentByCourse(id);
        return course;
    }

    public Course getCourse(String id){
        Course course = courses.get(id);
        if(course == null){
            throw new CourseNotFoundException(id);
        }
        return course;
    }

    public List<Course>search(String keyword){
        List<Course> result = new ArrayList<>();
        for(Course c: courses.values()){
            if(c.matches(keyword))result.add(c);
        }
        return result;
    }

    public List<Course> getAllCourse(){
        return new ArrayList<>(courses.values());
    }
}

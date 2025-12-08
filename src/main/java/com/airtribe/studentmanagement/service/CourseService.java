package com.airtribe.studentmanagement.service;

import com.airtribe.studentmanagement.entity.Course;

import java.util.*;

public class CourseService {
    private final Map<String, Course> courses = new HashMap<>();

    // Factory pattern
    public Course addCourse(String id, String name, String description){
        Course course = new Course(id, name, description);
        courses.put(course.getId(), course);
        return course;
    }

    public Course removeCourse(String id){
        return courses.remove(id);
    }

    public Course getCourse(String id){
        return courses.get(id);
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

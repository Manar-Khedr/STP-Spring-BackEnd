package com.sumerge.spring.implement;

import com.sumerge.spring3.Course;
import com.sumerge.spring3.CourseRecommender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CourseRecommenderImpl1 implements CourseRecommender{

    @Override
    public List<Course> recommendedCourses() {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Java Basics", 1, "Introduction to Java", 3));
        courseList.add(new Course("Database Basics", 2, "Introduction to Database", 3 ));

        return courseList;
    }
}
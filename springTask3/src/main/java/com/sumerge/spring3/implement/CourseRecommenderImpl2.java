package com.sumerge.spring3.implement;

import com.sumerge.spring3.Course;
import com.sumerge.spring3.CourseRecommender;

import java.util.ArrayList;
import java.util.List;

public class CourseRecommenderImpl2 implements CourseRecommender {

    @Override
    public List<Course> recommendedCourses() {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Course 3"));
        courseList.add(new Course("Course 4"));

        return courseList;
    }
}

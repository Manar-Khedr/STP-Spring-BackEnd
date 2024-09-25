package com.sumerge.spring.service;

import com.sumerge.spring.repository.CourseRepository;
import com.sumerge.spring3.Course;
import com.sumerge.spring3.CourseRecommender;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseService {

    private CourseRecommender courseRecommender;
    private CourseRepository courseRepository;


    // JDBC Template Constructor
    @Autowired
    public CourseService(CourseRecommender courseRecommender, CourseRepository courseRepository) {
        this.courseRecommender = courseRecommender;
        this.courseRepository = courseRepository;
    }

    public List<Course> getRecommendedCourses() {
        return courseRecommender.recommendedCourses();
    }

    // PostgreSQL
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }

    public void deleteCourse(Course course) {
        courseRepository.deleteCourse(course);
    }

    public Course viewCourse(int courseId) {
        return courseRepository.viewCourse(courseId);
    }

    public List<Course> viewAllCourses(){
        return courseRepository.viewAllCourses();
    }
}

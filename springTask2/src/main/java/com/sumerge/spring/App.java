package com.sumerge.spring;

import com.sumerge.spring.config.AppConfig;
import com.sumerge.spring.service.CourseService;
import com.sumerge.spring3.Course;
import com.sumerge.spring3.CourseRecommender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main(String[] args) {

        // 1
        explicitDeclare();
        // 2/3
        qualifierDifferentiate();
        // 4
        changedQualifier();

    }

    public static void explicitDeclare(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CourseRecommender courseRecommenderImpl1 = context.getBean("courseRecommenderImpl1" ,CourseRecommender.class);
        List<Course> recommendedCourses = courseRecommenderImpl1.recommendedCourses();
        for (Course course : recommendedCourses) {
            System.out.println("Recommended course: " + course.getName());
        }
        context.close();
    }

    public static void qualifierDifferentiate(){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CourseService courseService = context.getBean(CourseService.class);
        List<Course> courses = courseService.getRecommendedCourses();
        courses.forEach(course -> System.out.println("Recommended Course: "+course.getName()));
    }

    public static void changedQualifier(){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CourseService courseService = context.getBean(CourseService.class);
        List<Course> courses = courseService.getRecommendedCourses();
        courses.forEach(course -> System.out.println("Recommended Course: "+course.getName()));

    }
}

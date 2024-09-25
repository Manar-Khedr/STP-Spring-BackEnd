package com.sumerge.spring.config;

import com.sumerge.spring.implement.ChangedCourseRecommenderImpl2;
import com.sumerge.spring.implement.CourseRecommenderImpl1;
import com.sumerge.spring.service.CourseService;
import com.sumerge.spring3.CourseRecommender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sumerge.spring")
public class AppConfig {

    @Bean
    @Qualifier("courseRecommenderImpl1")
    public CourseRecommender courseRecommenderImpl1() {
        return new CourseRecommenderImpl1();
    }

    @Bean
    @Qualifier("courseRecommenderImpl2")
    public CourseRecommender courseRecommenderImpl2() {
        return new ChangedCourseRecommenderImpl2();
    }

    // Uncomment only when needed to see the OLD CourseRecommenderImpl2 before overriding
    // BUT comment the code above
//    @Bean
//    @Qualifier("courseRecommenderImpl2")
//    public CourseRecommender courseRecommenderImpl2() {
//        return new CourseRecommenderImpl2();
//    }

    @Bean
    public CourseService courseService(@Qualifier("courseRecommenderImpl2") CourseRecommender courseRecommender) {
        return new CourseService(courseRecommender);
    }

}
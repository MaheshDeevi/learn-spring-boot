package com.in28minutes.springboot.learnspringboot.demos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getAllCourses(){

        return Arrays.asList(
                new Course(1,"Learn AWS","mahesh"),
                new Course(2,"Learn Appium","mahesh"),
                new Course(3,"Learn Spring","mahesh deevi")
        );
    }
}

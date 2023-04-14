package com.in28minutes.springboot.learnspringboot.course;

import com.in28minutes.springboot.learnspringboot.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnspringboot.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Learn AWS","Mahesh"));
        repository.save(new Course(2,"Learn Testing","Mahesh"));
        repository.save(new Course(3,"Learn HTML","Raju"));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findByAuthor("Mahesh"));
//        System.out.println(repository.findById(3));
    }
}

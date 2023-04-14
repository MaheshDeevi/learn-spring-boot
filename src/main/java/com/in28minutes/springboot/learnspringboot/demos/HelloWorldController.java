package com.in28minutes.springboot.learnspringboot.demos;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String getMessage(){
        return "Hello-World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean getMessageBean(){

        return new HelloWorldBean("Hello-World-Bean");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean getMessagePath(@PathVariable String name){

        return new HelloWorldBean(String.format("Hello-World, %s",name));
    }
}

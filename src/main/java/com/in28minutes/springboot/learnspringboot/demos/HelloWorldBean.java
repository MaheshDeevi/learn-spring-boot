package com.in28minutes.springboot.learnspringboot.demos;

public class HelloWorldBean {

    private String message;
    public HelloWorldBean(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthenticationBean{" +
                "message='" + message + '\'' +
                '}';

    }
}
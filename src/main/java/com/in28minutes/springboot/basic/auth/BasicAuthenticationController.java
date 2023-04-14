package com.in28minutes.springboot.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {



    @GetMapping("/basic-auth")
    public AuthenticationBean getMessageBean(){

        return new AuthenticationBean("You are successfully authenticated");
    }


}

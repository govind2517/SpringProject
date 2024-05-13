package com.neog.studentmngmtsystem.controller;

import com.neog.studentmngmtsystem.model.User;
import com.neog.studentmngmtsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    UserService service;

    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }
}

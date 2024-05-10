package com.neog.helloproject.controller;

import com.neog.helloproject.model.User;
import com.neog.helloproject.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/welcome")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return homeService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getAllUsers(@PathVariable int id){
        return homeService.getUserById(id);
    }
}

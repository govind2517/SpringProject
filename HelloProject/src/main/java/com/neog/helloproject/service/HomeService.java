package com.neog.helloproject.service;

import com.neog.helloproject.model.UserType;
import com.neog.helloproject.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    //TODO: this can come from db, for now just hardcoding it
    List<User> users = Arrays.asList(
            new User(1, "Govind", UserType.LEARNER),
            new User(2, "Satwik", UserType.LEARNER),
            new User(3, "Dheeraj", UserType.INSTRUCTOR),
            new User(4, "Utakarsh", UserType.INSTRUCTOR),
            new User(5, "Kunal", UserType.MENTOR)
            );

    public List<User> getUsers(){
        return this.users;
    }

    public User getUserById(int id) {
        Optional<User> user = this.users.stream().filter((u)->u.getId() == id).findAny();
        //TODO: throw UserDetailNotFound exception if id not matched
        return user.orElseGet(User::new);
    }
}

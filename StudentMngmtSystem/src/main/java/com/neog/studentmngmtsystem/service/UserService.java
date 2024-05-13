package com.neog.studentmngmtsystem.service;

import com.neog.studentmngmtsystem.model.User;
import com.neog.studentmngmtsystem.repository.UserRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepsitory repo;

    public List<User> getUsers() {
        return repo.getUsers();
    }
}

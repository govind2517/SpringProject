package com.neog.studentmngmtsystem.repository;

import com.neog.studentmngmtsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepsitory {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        String query = "select id, email from users";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
    }
}

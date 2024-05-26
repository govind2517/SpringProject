package com.neog.studentmngmtsystem.repository;

import com.neog.studentmngmtsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getStudents() {
        String query = "select * from students";
        //String query = "select *, (case when gender = 'M' then 'MALE' else 'FEMALE' end) as gender from students";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
    }
}

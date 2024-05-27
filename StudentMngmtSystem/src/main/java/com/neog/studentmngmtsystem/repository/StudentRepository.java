package com.neog.studentmngmtsystem.repository;

import com.neog.studentmngmtsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository extends NamedParameterJdbcDaoSupport {

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate){
        setJdbcTemplate(jdbcTemplate);
    }

    public int getCountOfStudents(){
        String sql = "select count(1) from students";
        return getJdbcTemplate().queryForObject(sql, Integer.class);
    }

    public int getCountOfStudentsByBranch(String branch){
        String sql = "select count(1) from students where branch = :branch";
        Map<String, Object> params = new HashMap<>();
        params.put("branch", branch);
        return getNamedParameterJdbcTemplate().queryForObject(sql, params, Integer.class);
    }

    public List<Student> getStudents(String branch, String gender) {
        String sql = "select * from students";
        //String sql = "select *, (case when gender = 'M' then 'MALE' else 'FEMALE' end) as gender from students";
        Map<String, Object> params = new HashMap<>();
        if(branch != null){
            sql += " where branch = :branch";
            params.put("branch", branch);
            if(gender != null){
                sql += " and gender = :gender";
                params.put("gender", gender);
            }
        }else if(gender != null){
            sql += " where gender = :gender";
            params.put("gender", gender);
        }
        System.out.println("sql :: "+sql);
        return getNamedParameterJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<>(Student.class));
    }

    public Student getStudentsById(int id) {
        String sql = "select * from students where id = ?";
        return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
    }

    public void createStudent(Student student) {
        String sql = "insert into students(id, name, gender, branch, contact_no) values(:id, :name, :gender, :branch, :contactNo)";
        Map<String, Object> params = student.toMap();
        System.out.println(params);
        getNamedParameterJdbcTemplate().update(sql, params);
    }

    public void updateStudent(Student student, int id) {
        String sql = "update students set name = :name, gender = :gender, branch = :branch, contact_no = :contactNo where id = :id";
        Map<String, Object> params = student.toMap();
        params.put("id", id);
        System.out.println(params);
        getNamedParameterJdbcTemplate().update(sql, params);
    }

    public void deleteStudent(int id) {
        String query = "delete from students where id = ?";
        int rowAffected = getJdbcTemplate().update(query, id);
        System.out.println("rowAffected :: "+rowAffected);
    }

}

package com.neog.studentmngmtsystem.controller;

import com.neog.studentmngmtsystem.model.Student;
import com.neog.studentmngmtsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/health")
    public int getHealth(){
        return studentService.getStudentsCount();
    }

    @GetMapping("/count/{branch}")
    public int getCountByBranch(@PathVariable String branch){
        return studentService.getStudentsCountByBranch(branch);
    }

    @GetMapping
    public List<Student> getStudents(
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) String gender
    ){
        return studentService.getStudents(branch, gender);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student){
        studentService.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}

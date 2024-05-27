package com.neog.studentmngmtsystem.service;

import com.neog.studentmngmtsystem.model.Student;
import com.neog.studentmngmtsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public int getStudentsCount() {
        return studentRepository.getCountOfStudents();
    }

    public int getStudentsCountByBranch(String branch) {
        return studentRepository.getCountOfStudentsByBranch(branch);
    }

    public List<Student> getStudents(String branch, String gender) {
        return studentRepository.getStudents(branch, gender);
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentsById(id);
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public void updateStudent(Student student, int id) {
        studentRepository.updateStudent(student, id);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

}

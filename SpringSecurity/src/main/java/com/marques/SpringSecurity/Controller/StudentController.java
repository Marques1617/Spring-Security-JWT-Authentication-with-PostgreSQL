package com.marques.SpringSecurity.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marques.SpringSecurity.Model.Student;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Joao", "joao@example.com"),
        new Student(2, "Maria", "maria@example.com"),
        new Student(3, "Pedro", "pedro@example.com")
    ));

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
    
}
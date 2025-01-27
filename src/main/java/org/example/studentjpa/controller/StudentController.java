package org.example.studentjpa.controller;

import org.example.studentjpa.model.Student;
import org.example.studentjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }


}

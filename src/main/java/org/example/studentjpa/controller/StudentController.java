package org.example.studentjpa.controller;

import org.example.studentjpa.model.Student;
import org.example.studentjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }


    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student updateStudent(@RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(student.getId());
        if (orgStudent.isPresent()) {
            System.out.println(student);
            return studentRepository.save(student);
        } else {
            Student student1 = new Student();
            student1.setName("NotFound");
            return student1;
        }

    }


}

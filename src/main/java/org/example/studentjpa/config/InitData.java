package org.example.studentjpa.config;

import org.example.studentjpa.model.Student;
import org.example.studentjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Hans");
        s1.setBornDate(LocalDate.of(1999, 6, 27));
        s1.setBornTime(LocalTime.of(10, 5, 19));
        studentRepository.save(s1);
    }
}

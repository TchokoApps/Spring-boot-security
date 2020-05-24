package com.tchokoapps.springboot.springsecuritytutorial.controllers;

import com.tchokoapps.springboot.springsecuritytutorial.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    public final List<Student> students = Arrays.asList(
            new Student(1, "Charles"),
            new Student(2, "Billy"),
            new Student(3, "Jacqques"),
            new Student(4, "Yves"));

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable("id") Integer id) throws Throwable {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElseThrow(() -> new RuntimeException(String.format("Student with id: %s doesn´t exist", id)));
    }
}

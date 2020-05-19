package com.tchokoapps.springboot.studentservices.controllers;

import com.tchokoapps.springboot.studentservices.models.Course;
import com.tchokoapps.springboot.studentservices.models.Student;
import com.tchokoapps.springboot.studentservices.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{studentId}/courses")
    public List<Course> retrieveCoursesForStudent(@PathVariable int studentId) {
        return studentService.retrieveCourses(studentId);
    }
}

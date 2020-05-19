package com.tchokoapps.springboot.studentservices.services;

import com.tchokoapps.springboot.studentservices.models.Course;
import com.tchokoapps.springboot.studentservices.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private static List<Student> students = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "10 Steps", Arrays.asList("Learn Maven", "Import Project", "First Example",
                "Second Example"));
        Course course2 = new Course(2, "Spring MVC", "10 Examples", Arrays.asList("Learn Maven", "Import Project", "First Example",
                "Second Example"));

        Student student = new Student(1, "Alain Tchokonte", "Hiker, Programmer and Architect", new ArrayList<>(Arrays.asList(course1, course2)));

        students.add(student);
    }

    public Student retrieveStudent(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public List<Course> retrieveCourses(int studentId) {
        Student student = retrieveStudent(studentId);
        if(student != null) {
            return student.getCourses();
        }
        return null;
    }
}

package com.tchokoapps.springboot.studentservices.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Course {
    private int id;
    private String name;
    private String description;
    private List<String> steps;
}

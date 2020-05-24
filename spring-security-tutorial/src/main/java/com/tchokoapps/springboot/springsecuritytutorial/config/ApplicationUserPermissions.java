package com.tchokoapps.springboot.springsecuritytutorial.config;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ApplicationUserPermissions {

    STUDENT_READ("STUDENT_READ"),
    STUDENT_WRITE("STUDENT_WRITE"),
    COURSE_READ("COURSE_READ"),
    COURSE_WRITE("COURSE_WRITE");

    private final String permission;

}

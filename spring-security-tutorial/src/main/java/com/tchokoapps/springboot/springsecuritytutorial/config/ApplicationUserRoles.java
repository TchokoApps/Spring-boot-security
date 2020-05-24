package com.tchokoapps.springboot.springsecuritytutorial.config;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.tchokoapps.springboot.springsecuritytutorial.config.ApplicationUserPermissions.*;

@AllArgsConstructor
public enum ApplicationUserRoles {

    STUDENT(new HashSet<>()),
    ADMIN(new HashSet<>(Arrays.asList(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)));

    public final Set<ApplicationUserPermissions> permissions;
}

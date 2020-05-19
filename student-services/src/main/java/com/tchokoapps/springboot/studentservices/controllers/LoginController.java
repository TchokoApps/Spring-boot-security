package com.tchokoapps.springboot.studentservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/")
    public String showLoginPage(ModelMap model) {
        model.put("name", "TchokoApps");
        return "welcome";
    }
}

package com.lkimilhol.matchingProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @PostMapping("/")
    public String getMember() {
        return "";
    }
}

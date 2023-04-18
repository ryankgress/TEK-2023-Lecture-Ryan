package com.capstone.Inquizitive.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {
    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/signin/redirect")
    public String signinRedirect() {
        return "signinRedirect";
    }


}

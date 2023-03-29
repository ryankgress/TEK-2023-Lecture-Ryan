package com.capstone.Inquizitive.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)      // executes when index.html is visited
    public ModelAndView index() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("index");         // Return value from index.jsp
        return response;
    }
}

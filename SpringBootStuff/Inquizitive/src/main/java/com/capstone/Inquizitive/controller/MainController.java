package com.capstone.Inquizitive.controller;

import com.capstone.Inquizitive.database.dao.TeamMemberDAO;
import com.capstone.Inquizitive.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)      // executes when index.html is visited
    public ModelAndView index() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("index");         // Return value from index.jsp
        return response;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)      // executes when profile.html is visited
    public ModelAndView profile() {
        log.info("In the profile controller method");
        ModelAndView response = new ModelAndView("profile");         // Return value from profile.jsp
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)      // executes when register.html is visited
    public ModelAndView register() {
        log.info("In the register controller method");
        ModelAndView response = new ModelAndView("register");         // Return value from register.jsp
        return response;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)      // executes when signin.html is visited
    public ModelAndView signin() {
        log.info("In the signin controller method");
        ModelAndView response = new ModelAndView("signin");         // Return value from signin.jsp
        return response;
    }

    @Autowired
    private TeamMemberDAO teamMemberDao;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)      // executes when teams.html is visited
    public ModelAndView teams() {
        String team = "Breakout1";      // Will eventually be replaced with a GET from the page
        log.info("In the teams controller method with teamname = " + team);
        ModelAndView response = new ModelAndView("teams");         // Return value from teams.jsp

        List<User> members = teamMemberDao.getUsersByTeamName(team);

        response.addObject("t1List", members);

        return response;
    }

    @RequestMapping(value = "/trivialist", method = RequestMethod.GET)      // executes when trivialist.html is visited
    public ModelAndView trivialist() {
        log.info("In the trivialist controller method");
        ModelAndView response = new ModelAndView("trivialist");         // Return value from trivialist.jsp
        return response;
    }
}

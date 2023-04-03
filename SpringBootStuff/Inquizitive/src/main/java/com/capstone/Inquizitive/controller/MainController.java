package com.capstone.Inquizitive.controller;

import com.capstone.Inquizitive.database.dao.TeamDAO;
import com.capstone.Inquizitive.database.dao.TeamMemberDAO;
import com.capstone.Inquizitive.database.dao.UserDAO;
import com.capstone.Inquizitive.database.entity.Team;
import com.capstone.Inquizitive.database.entity.User;
import com.capstone.Inquizitive.formbeans.UserRegisterBean;
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

    @Autowired
    private TeamMemberDAO teamMemberDao;

    @Autowired
    private TeamDAO teamDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = {"/index", "/", "/index.html"}, method = RequestMethod.GET)      // executes when index.html is visited
    public ModelAndView index() {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");         // Return value from index.jsp
        return response;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)      // executes when profile.html is visited
    public ModelAndView profile() {
        log.debug("In the profile controller method");
        ModelAndView response = new ModelAndView("profile");         // Return value from profile.jsp
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)      // executes when register.html is visited
    public ModelAndView register() {
        log.debug("In the register controller method");
        ModelAndView response = new ModelAndView("register");         // Return value from register.jsp

        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)      // executes when register.html is visited
    public ModelAndView registerSubmit(UserRegisterBean form) {
        log.debug("In the register controller registerSubmit method");
        ModelAndView response = new ModelAndView("register");         // Return value from register.jsp

        User user = new User();
        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());

        response.addObject("user", user);
        log.debug(user.toString());

        userDao.save(user);

        return response;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)      // executes when signin.html is visited
    public ModelAndView signin() {
        log.debug("In the signin controller method");
        ModelAndView response = new ModelAndView("signin");         // Return value from signin.jsp
        return response;
    }



    @RequestMapping(value = "/teams", method = RequestMethod.GET)      // executes when teams.html is visited
    public ModelAndView teams() {
        String team = "Breakout1";      // Will eventually be replaced with a GET from the page
        log.debug("In the teams controller method with teamname = " + team);
        ModelAndView response = new ModelAndView("teams");         // Return value from teams.jsp

        List<User> members = teamMemberDao.getUsersByTeamName(team);
        Team teamObj = teamDao.findByTeamName(team);

        response.addObject("team", teamObj);
        response.addObject("t1List", members);

        return response;
    }

    @RequestMapping(value = "/trivialist", method = RequestMethod.GET)      // executes when trivialist.html is visited
    public ModelAndView trivialist() {
        log.debug("In the trivialist controller method");
        ModelAndView response = new ModelAndView("trivialist");         // Return value from trivialist.jsp
        return response;
    }
}

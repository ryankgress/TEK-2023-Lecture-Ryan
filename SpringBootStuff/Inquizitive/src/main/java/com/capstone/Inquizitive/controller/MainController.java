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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private TeamMemberDAO teamMemberDao;

    @Autowired
    private TeamDAO teamDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = {"/index", "/", "/index.html"}, method = RequestMethod.GET)
    public ModelAndView index() {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        log.debug("In the profile controller method");
        ModelAndView response = new ModelAndView("profile");
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        log.debug("In the register controller method");
        ModelAndView response = new ModelAndView("register");

        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(UserRegisterBean form) {
        log.debug("In the register controller registerSubmit method");
        ModelAndView response = new ModelAndView("register");

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

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        log.debug("In the signin controller method");
        ModelAndView response = new ModelAndView("signin");
        return response;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ModelAndView teams() {
        log.debug("In the teams controller method");
        ModelAndView response = new ModelAndView("teams");

//        List<Team> allTeams = teamDao.getAllTeams();
//        List<List<User>> members = new ArrayList<>();
        List<Map<String,Object>> memberList = teamDao.getAllTeamsAndMembers();
//        for(Team t : allTeams) {
//            members.add(teamMemberDao.getUsersByTeamName(t.getTeamName()));
//            log.debug(t.toString());
//        }
//        log.debug(members.toString());
        log.debug(memberList.toString());
        for(Map<String,Object> m : memberList) {
//            for(String key : m.keySet()) {
//                log.debug("Key = " + key + "  | Value = " + m.get(key));
//            }
            log.debug(m.get("team_name") + " - " + m.get("team_members"));
        }
        

//        response.addObject("allTeams", allTeams);
//        response.addObject("members", members);
        response.addObject("memberList", memberList);
        return response;
    }



    @RequestMapping(value = "/trivialist", method = RequestMethod.GET)
    public ModelAndView trivialist() {
        log.debug("In the trivialist controller method");
        ModelAndView response = new ModelAndView("trivialist");
        return response;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test() {
        String team = "Breakout1";      // Will eventually be replaced with a GET from the page
        log.debug("In the test controller method with teamname = " + team);
        ModelAndView response = new ModelAndView("test");

        List<User> members = teamMemberDao.getUsersByTeamName(team);
        Team teamObj = teamDao.findByTeamName(team);

        response.addObject("team", teamObj);
        response.addObject("t1List", members);

        return response;
    }
}

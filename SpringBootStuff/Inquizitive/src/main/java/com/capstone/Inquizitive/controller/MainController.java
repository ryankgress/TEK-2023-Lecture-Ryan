package com.capstone.Inquizitive.controller;

import com.capstone.Inquizitive.database.dao.TeamDAO;
import com.capstone.Inquizitive.database.dao.TeamMemberDAO;
import com.capstone.Inquizitive.database.dao.UserDAO;
import com.capstone.Inquizitive.database.dao.UserRoleDAO;
import com.capstone.Inquizitive.database.entity.Team;
import com.capstone.Inquizitive.database.entity.TeamMember;
import com.capstone.Inquizitive.database.entity.User;
import com.capstone.Inquizitive.database.entity.UserRole;
import com.capstone.Inquizitive.formbeans.UserBean;
import com.capstone.Inquizitive.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
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

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    @RequestMapping(value = {"/index", "/", "/index.html"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }


//    @RequestMapping(value = "/profile/log/{username}", method = RequestMethod.GET)
//    public ModelAndView profile(@PathVariable String username) {
//        log.debug("In the pre-profile controller method");
//
//        User user = userDao.findByUsername(username);
//        ModelAndView response = new ModelAndView("profile");
//        response.addObject("user", user);
//        response.setViewName("redirect:/profile/{" + user.getId() + "}");
//        return response;
//    }

    @RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
    public ModelAndView profile(@PathVariable String username) {
        log.debug("In the profile controller method");
        ModelAndView response = new ModelAndView("profile");


        User user = userDao.findByUsername(username);
//        User user = userDao.findById(id);
        List<Map<String,Object>> teams = teamMemberDao.getTeamsByUserId(user.getId());

        Integer totScore = teamMemberDao.getUserTotalById(user.getId());

        response.addObject("teams", teams);
        response.addObject("user", user);
        response.addObject("totScore", totScore);
        return response;
    }

    @RequestMapping(value = "/editProfile/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("editProfile");


        User user = userDao.findById(id);
        UserBean form = new UserBean();

        form.setId(user.getId());
        form.setName(user.getName());
        form.setUsername(user.getUsername());
        form.setEmail(user.getEmail());
        form.setPassword(user.getPassword());
        form.setProfilePic(user.getProfilePic());

        response.addObject("form", form);

        log.debug("In edit profile controller method");

        return response;
    }

    @RequestMapping(value = "/editProfileSubmit", method = RequestMethod.POST)
    public ModelAndView editProfileSubmit(UserBean form, HttpSession httpSession) throws IOException {
        log.debug("In the editProfile controller submit method");
        ModelAndView response = new ModelAndView("editLanding");

        User user = userDao.findById(form.getId());
        File target;


        if(!form.getProfilePicture().isEmpty()) {
            target = new File("./src/main/webapp/pub/images/" + form.getProfilePicture().getOriginalFilename());
            log.debug("Target path: " + target.getAbsolutePath());
            FileUtils.copyInputStreamToFile(form.getProfilePicture().getInputStream(), target);
            user.setProfilePic("/pub/images/" + form.getProfilePicture().getOriginalFilename());
        } else {
            user.setProfilePic("/pub/images/default-pfp.png");
        }

        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());

        response.addObject("user", user);
        log.debug(user.toString());

        userDao.save(user);
        // Need to access unencrypted password somehow
        authenticatedUserService.changeLoggedInUsername(httpSession, user.getUsername(), user.getPassword());

        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        log.debug("In the register controller method");
        ModelAndView response = new ModelAndView("register");

        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@Valid UserBean form, BindingResult bindingResult, HttpSession httpSession) throws IOException {
        log.debug("In the register controller registerSubmit method");
        ModelAndView response = new ModelAndView("register");

        if(bindingResult.hasErrors()) {
            for(FieldError error : bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field : " + error.getField() + " with message : " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);
            return response;
        }

        File target;
        User user = new User();

        if(!form.getProfilePicture().isEmpty()) {
            target = new File("./src/main/webapp/pub/images/" + form.getProfilePicture().getOriginalFilename());
            log.debug("Target path: " + target.getAbsolutePath());
            FileUtils.copyInputStreamToFile(form.getProfilePicture().getInputStream(), target);
            user.setProfilePic("/pub/images/" + form.getProfilePicture().getOriginalFilename());
        } else {
            user.setProfilePic("/pub/images/default-pfp.png");
        }

        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());

        String encPass = passwordEncoder.encode(form.getPassword());
        user.setPassword(encPass);

        response.addObject("user", user);
        log.debug(user.toString());

        userDao.save(user);

        if(form.getHost() != null) {
            UserRole userRoleHost = new UserRole();
            userRoleHost.setRoleName("HOST");
            userRoleHost.setUserId(user.getId());
            userRoleDao.save(userRoleHost);
        }

        // User Role Assignment
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());
        userRoleDao.save(userRole);



        authenticatedUserService.changeLoggedInUsername(httpSession, form.getUsername(), form.getPassword());

        // If successful, redirect to index
        response.setViewName("redirect:/index");

        return response;
    }


    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ModelAndView teams() {
        List<Team> teamsList = teamDao.getAllTeams();
        log.debug("In the teams controller method");
        ModelAndView response = new ModelAndView("teams");

        List<Map<String,Object>> memberList = teamDao.getAllTeamsAndMembers();

//        for(Map<String,Object> m : memberList) {
//            log.debug(m.get("team_name") + " - " + m.get("team_members"));
//        }

        response.addObject("memberList", memberList);
        return response;
    }

    @RequestMapping(value = "/teams/{teamId}", method = RequestMethod.GET)
    public ModelAndView teams(@PathVariable Integer teamId) {
        List<Team> teamsList = teamDao.getAllTeams();
        log.debug("In the teams controller method");
        ModelAndView response = new ModelAndView("teams");



        String thisName = authenticatedUserService.getCurrentUsername();
        log.debug(thisName);

        User user = userDao.findByUsername(authenticatedUserService.getCurrentUsername());

        TeamMember teamMember = new TeamMember();
        teamMember.setUserId(user.getId());
        teamMember.setTeamId(teamId);
        teamMember.setTeam(teamDao.findById(teamId));
        teamMember.setUser(userDao.findById(user.getId()));

        log.debug("User ID: " + teamMember.getUserId() + " | Team ID: " + teamMember.getTeamId());

        teamMemberDao.save(teamMember);
        List<Map<String,Object>> memberList = teamDao.getAllTeamsAndMembers();

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

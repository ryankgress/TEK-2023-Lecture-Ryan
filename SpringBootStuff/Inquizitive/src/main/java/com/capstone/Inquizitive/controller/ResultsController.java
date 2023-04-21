package com.capstone.Inquizitive.controller;

import com.capstone.Inquizitive.database.dao.*;
import com.capstone.Inquizitive.database.entity.Team;
import com.capstone.Inquizitive.database.entity.TriviaDetail;
import com.capstone.Inquizitive.database.entity.User;
import com.capstone.Inquizitive.formbeans.ResultsBean;
import com.capstone.Inquizitive.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ResultsController {
    @Autowired
    private TeamDAO teamDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private TriviaDetailDAO triviaDetailDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private TeamMemberDAO teamMemberDao;

    @Autowired
    private ResultDAO resultDao;

    @RequestMapping(value = "/results/{triviaId}", method = RequestMethod.GET)
    public ModelAndView results(@PathVariable Integer triviaId) {
        log.debug("In the results controller method");
        ModelAndView response = new ModelAndView("results");

        TriviaDetail trivia = triviaDetailDao.findById(triviaId);
        User user = authenticatedUserService.loadCurrentUser();

        List<Map<String, Object>> teams = resultDao.getTeamsByTriviaId(triviaId);

        response.addObject("teams", teams);
        response.addObject("user", user);
        response.addObject("trivia", trivia);
        return response;
    }

    @PostMapping(value = "/results/submit")
    public ModelAndView resultsSubmit(ResultsBean form) {
        log.debug("In the results controller method");
        ModelAndView response = new ModelAndView("results");    // change?


        // Marks this trivia as complete
        TriviaDetail trivia = form.getTriviaDetail();
        trivia.setActive("false");
        triviaDetailDao.save(trivia);


        return response;
    }
}

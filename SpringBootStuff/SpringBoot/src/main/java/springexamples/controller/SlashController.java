package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    private EmployeeDAO employeeDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)      // executes when index.html is visited
    public ModelAndView index() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("index");         // Return value from index.jsp
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)      // executes when signup.html is visited
    public ModelAndView setup() {
        log.info("In the setup controller method");
        ModelAndView response = new ModelAndView("signup");         // Return value from signup.jsp
        return response;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)      // executes when signup.html is visited
    public ModelAndView bootstrap() {
        log.info("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("bootstrap");         // Return value from signup.jsp
        return response;
    }
}

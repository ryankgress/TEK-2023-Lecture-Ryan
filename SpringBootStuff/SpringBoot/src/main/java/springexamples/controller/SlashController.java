package springexamples.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;

@Slf4j
@Controller
public class SlashController {

    @RequestMapping(value = {"/index", "/", "/index.html"}, method = RequestMethod.GET)  // defaults to index if left blank
    public ModelAndView index(HttpSession session) {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");         // Return value from index.jsp

        session.setAttribute("name","Ryan");

        log.debug("SESSION ATTRIBUTE: " + session.getAttribute("name"));

        log.trace("This is a trace log example");
        log.debug("This is a debug log example");
        log.info("This is an info log example");
        log.error("This is an error log example");
        log.warn("This is a warn log example");

        return response;
    }

    @GetMapping("/signup")              // Same as @RequestMapping(method = RequestMethod.GET)
    public ModelAndView setup(HttpSession session) {
        session.setAttribute("name", "Not Ryan");
        log.debug("In the signup controller method - " + session.getAttribute("name"));
        ModelAndView response = new ModelAndView("signup");         // Return value from signup.jsp
        return response;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)      // executes when signup.html is visited
    public ModelAndView bootstrap() {
        log.debug("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("bootstrap");         // Return value from signup.jsp
        return response;
    }
}

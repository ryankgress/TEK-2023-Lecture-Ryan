package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class EmployeeController {

    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch() {
        log.info("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("employee/employee-search");         // Return value from employee-search.jsp
        return response;
    }
}

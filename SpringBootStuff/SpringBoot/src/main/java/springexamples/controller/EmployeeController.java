package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstSearch, @RequestParam(required = false) String lastSearch) {     // grabbing search value from HTML
        log.info("In the employee-search controller method with search = " + firstSearch);
        ModelAndView response = new ModelAndView("employee/employee-search");         // Return value from employee-search.jsp

        List<Employee> employees = employeeDao.findByFirstNameContainingOrLastNameContaining(firstSearch, lastSearch);
//      List<Employee> employees = employeeDao.usingNativeQuery(search, search);
//      List<Employee> employees = employeeDao.usingJPAQuery(firstSearch, lastSearch);
        response.addObject("employeesList", employees);
        response.addObject("firstSearch", firstSearch);   // Pass things from controller to JSP
        response.addObject("lastSearch", lastSearch);   // Pass things from controller to JSP

        return response;
    }
}

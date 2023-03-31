package springexamples.controller;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;
import springexamples.formbeans.EmployeeFormBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")        // Only accepts url if it starts with /employee
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");

        log.info("In employee detail controller method with id = " + id);

        Employee employee = employeeDao.findById(id);
        log.info(employee + " ");

        response.addObject("employee", employee);

        return response;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");

        log.info("In employee create controller method");

        return response;
    }

    @RequestMapping(value = "/createSubmit", method = RequestMethod.GET)
    public ModelAndView createSubmit(EmployeeFormBean form) {
        ModelAndView response = new ModelAndView("employee/create");

        log.info("In employee controller create submit method");
        log.info(form.toString());

        Employee emp = new Employee();
        emp.setFirstName(form.getFirstName());
        emp.setLastName(form.getLastName());
        emp.setEmail(form.getEmail());
        emp.setExtension(form.getExtension());
        emp.setJobTitle(form.getJobTitle());
        emp.setVacationHours(form.getVacationHours());
        emp.setOfficeId(1);

        employeeDao.save(emp);

        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {     // grabbing search value from HTML
        log.info("In the employee-search controller method with first = " + firstName + " and last = " + lastName);
        ModelAndView response = new ModelAndView("employee/search");         // Return value from search.jsp

        List<Employee> employees = new ArrayList<>();

        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            // if so run the query that works with both values
            log.info("Both first name and last name have a value");
            employees = employeeDao.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        }

        // check if the first name is NOT empty and the last name is empty
        if (!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            // we run our query that checks the fist name field only
            log.info("First name has a value and last name is empty");
            employees = employeeDao.findByFirstNameContainingIgnoreCase(firstName);
        }

        // check if the first name is empty and the last name is NOT empty
        if (StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            // we run our query that checks the last name field only
            log.info("Last name has a value and first name is empty");
            employees = employeeDao.findByLastNameContainingIgnoreCase(lastName);
        }

//      List<Employee> employees = employeeDao.usingNativeQuery(search, search);
//      List<Employee> employees = employeeDao.usingJPAQuery(firstName, lastName);
        response.addObject("employeesList", employees);
        response.addObject("firstName", firstName);   // Pass things from controller to JSP
        response.addObject("lastName", lastName);   // Pass things from controller to JSP

        return response;
    }
}

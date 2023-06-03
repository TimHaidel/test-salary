package by.intexsoft.salary.controller;

import by.intexsoft.salary.dao.EmployeeRepository;
import by.intexsoft.salary.model.Employee;
import by.intexsoft.salary.model.WorkedTime;
import by.intexsoft.salary.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for distributing salary
 *
 * @author Tsimur Haidel
 */
@Validated
@RestController
@RequestMapping("/period/2023-03")
public class SalaryDistributionController {

    private final Logger logger = LoggerFactory.getLogger(SalaryDistributionController.class);
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public SalaryDistributionController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/distribute-salary")
    public List<Employee> distributeSalary(@RequestBody List<WorkedTime> workedTimes) {
        try {
            var team = employeeRepository.getTeam();
            return employeeService.distributeSalary(team, workedTimes);
        } catch (Exception e) {
            logger.error("There is a problem with distribution salary");
            throw e;
        }
    }
}

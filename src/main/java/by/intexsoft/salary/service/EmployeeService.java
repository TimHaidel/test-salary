package by.intexsoft.salary.service;

import by.intexsoft.salary.model.Employee;
import by.intexsoft.salary.model.WorkedTime;

import java.util.List;

/**
 * Service for entity {@link Employee}
 *
 * @author Tsimur Haidel
 */
public interface EmployeeService {

    /**
     * Distribute salary
     *
     * @param team list of employees
     * @param workedTimes list of workedTime
     * @return list of employees with distributed salary
     */
    List<Employee> distributeSalary(List<Employee> team, List<WorkedTime> workedTimes);
}

package by.intexsoft.salary.dao;

import by.intexsoft.salary.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tsimur Haidel
 */
@Repository
public class EmployeeRepository {

    //TODO Implement with a database
    public List<Employee> getTeam() {
        List<Employee> team = new ArrayList<>();
        team.add(new Employee("1", 5000));
        team.add(new Employee("2", 6000));
        team.add(new Employee("3", 4000));

        return team;
    }
}

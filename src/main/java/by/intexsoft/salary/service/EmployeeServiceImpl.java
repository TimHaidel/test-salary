package by.intexsoft.salary.service;

import by.intexsoft.salary.model.Employee;
import by.intexsoft.salary.model.WorkedTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of Service for entity {@link Employee}
 *
 * @author Tsimur Haidel
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> distributeSalary(List<Employee> team, List<WorkedTime> workedTimes) {
        var workTimeMap = mapWorkTimeToMitarbeiterId(workedTimes);
        distribute(team, workTimeMap);
        return team;
    }

    private void distribute(List<Employee> team, Map<String, Integer> workedTime) {
        int totalWorkedTime = countTotalWorkedTime(workedTime);

        for (Employee employee : team) {
            String mitarbeiterId = employee.getMitarbeiterId();
            if (workedTime.containsKey(mitarbeiterId)) {
                int time = workedTime.get(mitarbeiterId);
                double salary = employee.getSalary() * time / totalWorkedTime;
                employee.setSalary(salary);
            } else {
                employee.setSalary(0);
            }
        }
    }

    private int countTotalWorkedTime(Map<String, Integer> workedTime) {
        int totalWorkedTime = 0;
        for (int time : workedTime.values()) {
            totalWorkedTime += time;
        }
        return totalWorkedTime;
    }

    private Map<String, Integer> mapWorkTimeToMitarbeiterId(List<WorkedTime> workedTimes) {
        Map<String, Integer> workedTimeMap = new HashMap<>();
        for (WorkedTime workedTime : workedTimes) {
            workedTimeMap.put(workedTime.getMitarbeiterId(), workedTime.getDauer());
        }

        return workedTimeMap;
    }

}

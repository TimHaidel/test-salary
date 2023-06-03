package by.intexsoft.salary.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author Tsimur Haidel
 */
@Schema(description = "Employee")
public class Employee {

    @Positive
    @NotNull
    private String mitarbeiterId;
    private double salary;

    public Employee(String mitarbeiterId, double salary) {
        this.mitarbeiterId = mitarbeiterId;
        this.salary = salary;
    }

    @Schema(description = "ID")
    public String getMitarbeiterId() {
        return mitarbeiterId;
    }

    public void setMitarbeiterId(String mitarbeiterId) {
        this.mitarbeiterId = mitarbeiterId;
    }

    @Schema(description = "Salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

package spring.ren.spring.project.service;

import spring.ren.spring.project.entities.Employee;

import java.util.Optional;

public interface EmployeeService {

    // Read operation
    Iterable<Employee> getEmployee();

    Optional<Employee> getEmployeeById(Long id);

    // Save operation
    Employee addEmployee(Employee employee);

    // Update operation
    Employee updateEmployee(Employee employee, Long id);

    //     Delete operation
    void deleteEmployeeById(Long id);
}

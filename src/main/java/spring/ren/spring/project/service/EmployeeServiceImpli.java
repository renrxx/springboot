package spring.ren.spring.project.service;

import spring.ren.spring.project.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ren.spring.project.repository.EmployeeRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpli implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        Employee employeeData = employeeRepository.findById(id).get();

        if (Objects.nonNull(employee.getName())
                && !"".equalsIgnoreCase(
                employee.getName())) {
            employeeData.setName(
                    employee.getName());
        }

        if (Objects.nonNull(
                employee.getDescription())
                && !"".equalsIgnoreCase(
                employee.getDescription())) {
            employeeData.setDescription(
                    employee.getDescription());
        }

        if (Objects.nonNull(employee.getAge())) {
            employeeData.setAge(
                    employee.getAge());
        }
        return employeeRepository.save(employeeData);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}

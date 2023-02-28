package spring.ren.spring.project.repository;

import spring.ren.spring.project.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByName(String name); //for testClass
}

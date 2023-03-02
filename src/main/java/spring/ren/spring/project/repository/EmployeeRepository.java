package spring.ren.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.ren.spring.project.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name); //for testClass
}

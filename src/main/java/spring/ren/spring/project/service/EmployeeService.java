package spring.ren.spring.project.service;

import org.springframework.stereotype.Service;
import spring.ren.spring.project.dto.EmployeeDTO;

import java.util.List;

@Service
public interface EmployeeService {

    List<EmployeeDTO> getEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO addEmployee(EmployeeDTO employee);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employee);

    void deleteEmployeeById(Long id);
}

package spring.ren.spring.project.mapper;

import spring.ren.spring.project.dto.EmployeeDTO;
import spring.ren.spring.project.model.Employee;

public interface EmployeeMapper {

    EmployeeDTO modelToDto(Employee employee);
    Employee dtoToModel(EmployeeDTO employeeDTO);
}


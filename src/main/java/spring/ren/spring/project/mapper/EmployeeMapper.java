package spring.ren.spring.project.mapper;

import org.mapstruct.Mapper;
import spring.ren.spring.project.dto.EmployeeDTO;
import spring.ren.spring.project.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO modelToDto(Employee employee);
    Employee dtoToModel(EmployeeDTO employeeDTO);
}


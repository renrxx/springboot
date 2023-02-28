package spring.ren.spring.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ren.spring.project.dto.EmployeeDTO;
import spring.ren.spring.project.model.Employee;
import spring.ren.spring.project.repository.EmployeeRepository;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpli implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = employees.stream().map(product -> modelMapper.map(employees, EmployeeDTO.class)).toList();
        return employeeDTOs;
//        return productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDTO savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDTO.class);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id ,EmployeeDTO employee) {

        Employee employeeData = employeeRepository.findById(id).get();

        if (Objects.nonNull(employeeData.getName())
                && !"".equalsIgnoreCase(
                employeeData.getName())) {
            employeeData.setName(
                    employeeData.getName());
        }

        if (Objects.nonNull(
                employeeData.getDescription())
                && !"".equalsIgnoreCase(
                employeeData.getDescription())) {
            employeeData.setDescription(
                    employeeData.getDescription());
        }

        if (Objects.nonNull(employeeData.getAge())) {
            employeeData.setAge(
                    employee.getAge());
        }

        if (Objects.nonNull(
                employeeData.getPosition())
                && !"".equalsIgnoreCase(
                employeeData.getPosition())) {
            employeeData.setPosition(
                    employeeData.getPosition());
        }

        Employee savedEmployee = employeeRepository.save(employeeData);
        EmployeeDTO employeeDTO = modelMapper.map(savedEmployee, EmployeeDTO.class);

        return employeeDTO;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}

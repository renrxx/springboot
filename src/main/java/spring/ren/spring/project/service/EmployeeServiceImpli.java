package spring.ren.spring.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ren.spring.project.dto.EmployeeDTO;
import spring.ren.spring.project.exceptions.RecordNotFoundException;
import spring.ren.spring.project.mapper.EmployeeMapper;
import spring.ren.spring.project.model.Employee;
import spring.ren.spring.project.repository.EmployeeRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpli implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> employeeMapper.modelToDto(employee)).toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return employeeMapper.modelToDto(employee);
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.modelToDto(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id ,EmployeeDTO employeeDto) throws RecordNotFoundException {

        Optional<Employee> employeeId= employeeRepository.findById(id);
        if(employeeId.isEmpty()){
            throw new RecordNotFoundException("Product not found with id " + id);
        }

        Employee employeeData = employeeRepository.findById(id).get();
        if (Objects.nonNull(employeeData.getName())
                && !"".equalsIgnoreCase(
                employeeData.getName())) {
            employeeData.setName(
                    employeeDto.getName());
        }

        if (Objects.nonNull(
                employeeData.getDescription())
                && !"".equalsIgnoreCase(
                employeeData.getDescription())) {
            employeeData.setDescription(
                    employeeDto.getDescription());
        }

        if (Objects.nonNull(employeeData.getAge())) {
            employeeData.setAge(
                    employeeDto.getAge());
        }

        if (Objects.nonNull(
                employeeData.getPosition())
                && !"".equalsIgnoreCase(
                employeeData.getPosition())) {
            employeeData.setPosition(
                    employeeDto.getPosition());
        }

        Employee savedEmployee = employeeRepository.save(employeeData);

        return employeeMapper.modelToDto(savedEmployee);
    }

    public void deleteEmployeeById(Long id)  throws RecordNotFoundException {
        Optional<Employee> productId= employeeRepository.findById(id);
        if(productId.isEmpty()){
            throw new RecordNotFoundException("Product not found with id " + id);
        }
        employeeRepository.deleteById(id);
    }
}

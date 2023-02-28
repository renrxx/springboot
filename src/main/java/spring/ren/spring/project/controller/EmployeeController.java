package spring.ren.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ren.spring.project.dto.EmployeeDTO;
import spring.ren.spring.project.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return "Successfully Deleted";
    }
}

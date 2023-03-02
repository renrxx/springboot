package spring.ren.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.ren.spring.project.dto.EmployeeDTO;
import spring.ren.spring.project.exceptions.RecordNotFoundException;
import spring.ren.spring.project.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
//        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
//        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addProduct(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
//        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employee) throws RecordNotFoundException {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException{
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Product Successfully Deleted", HttpStatus.OK);
//        return "Successfully Deleted";
    }
}

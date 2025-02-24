package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public ResponseEntity<String> testAPI() {
        return ResponseEntity.ok("Employee Payroll REST API is working!");
    }

    // GET - Fetching employee by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // GET - Fetching all employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // POST - Adding an employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return employeeService.addEmployee(employee);
    }

    // PUT - Updating employee data
    @PutMapping("/id/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setName(employeeDTO.getName());
        updatedEmployee.setSalary(employeeDTO.getSalary());
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // DELETE - Removing employee data
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}

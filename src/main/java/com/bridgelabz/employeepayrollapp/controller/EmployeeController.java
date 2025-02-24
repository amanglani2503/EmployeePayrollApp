package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public ResponseEntity<String> testAPI() {
        return ResponseEntity.ok("Employee Payroll REST API is working!");
    }

    // GET - Fetching employee by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // GET - Fetching all employees
    @GetMapping("/all")
    public ResponseEntity<String> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // POST - Adding an employee
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // PUT - Updating employee data
    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // DELETE - Removing employee data
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}

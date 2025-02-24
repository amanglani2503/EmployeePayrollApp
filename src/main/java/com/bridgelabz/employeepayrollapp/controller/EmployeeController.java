package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
class EmployeePayrollController {
    @GetMapping("/test")
    public String testAPI() {
        return "Employee Payroll REST API is working!";
    }


    // GET request - Fetching employee with given id
    @GetMapping("id/{id}")
    public String getEmployye(@PathVariable Long id){
        return "Fetching employee with id " + id;
    }

    // GET request - fetching all employees
    @GetMapping("/all")
    public String getAllEmployye(){
        return "Fetching all employees";
    }

    // POST request - Adding employee
    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }


    // PUT request - updating employee data
    @PutMapping("id/{id}")
    public String updateEmployee() {
        return "Employee updated!";
    }

    // DELETE request - Removing employee
    @DeleteMapping("id/{id}")
    public String deleteEmployee() {
        return "Employee deleted!";
    }
}

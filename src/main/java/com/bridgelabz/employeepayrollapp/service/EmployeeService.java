package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // Create an Employee
    public ResponseEntity<String> addEmployee(Employee employee) {
        return ResponseEntity.ok("Employee added successfully");
    }

    // Get Employee by ID
    public ResponseEntity<String> getEmployeeById(Long id) {
        return ResponseEntity.ok("Employee details retrieved successfully for ID: " + id);
    }

    // Get all Employees
    public ResponseEntity<String> getAllEmployees() {
        return ResponseEntity.ok("Employee list retrieved successfully");
    }

    // Update Employee
    public ResponseEntity<String> updateEmployee(Long id, Employee updatedEmployee) {
        return ResponseEntity.ok("Employee details updated successfully for ID: " + id);
    }

    // Delete Employee
    public ResponseEntity<String> deleteEmployee(Long id) {
        return ResponseEntity.ok("Employee deleted successfully for ID: " + id);
    }
}

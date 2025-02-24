package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1;

    // Create an Employee
    public ResponseEntity<Employee> addEmployee(Employee employee) {
        employee.setId((int) idCounter++);
        employeeList.add(employee);
        return ResponseEntity.ok(employee);
    }

    // Get Employee by ID
    public ResponseEntity<Employee> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeList.stream()
                .filter(emp -> emp.getId() == id.intValue())
                .findFirst();

        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all Employees
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeList);
    }

    // Update Employee
    public ResponseEntity<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id.intValue()) {
                emp.setName(updatedEmployee.getName());
                emp.setSalary(updatedEmployee.getSalary());
                return ResponseEntity.ok(emp);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Employee
    public ResponseEntity<String> deleteEmployee(Long id) {
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id.intValue());
        if (removed) {
            return ResponseEntity.ok("Employee deleted successfully for ID: " + id);
        }
        return ResponseEntity.notFound().build();
    }
}

package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

    // Create an Employee
    public ResponseEntity<Employee> addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId((int) idCounter++);
        employee.setName(employeeDTO.getName());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setGender(employeeDTO.getGender());
        employee.setDepartments(employeeDTO.getDepartments());
        employee.setSalary(employeeDTO.getSalary());
        employee.setStartDate(LocalDate.parse(employeeDTO.getStartDate(), formatter));
        employee.setNote(employeeDTO.getNote());

        employeeList.add(employee);
        log.info("Added Employee: {}", employee);
        return ResponseEntity.ok(employee);
    }

    // Getting Employee by ID
    public ResponseEntity<Employee> getEmployeeById(Long id) {
        log.info("Fetching Employee with ID: {}", id);
        Optional<Employee> employee = employeeList.stream()
                .filter(emp -> emp.getId() == id.intValue())
                .findFirst();

        return employee.map(ResponseEntity::ok)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
    }

    // Getting all Employees
    public ResponseEntity<List<Employee>> getAllEmployees() {
        log.info("Fetching all employees. Total count: {}", employeeList.size());
        return ResponseEntity.ok(employeeList);
    }

    // Updating employee details
    public ResponseEntity<Employee> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        log.info("Updating Employee with ID: {}", id);
        for (Employee emp : employeeList) {
            if (emp.getId() == id.intValue()) {
                emp.setName(employeeDTO.getName());
                emp.setProfilePic(employeeDTO.getProfilePic());
                emp.setGender(employeeDTO.getGender());
                emp.setDepartments(employeeDTO.getDepartments());
                emp.setSalary(employeeDTO.getSalary());
                emp.setStartDate(LocalDate.parse(employeeDTO.getStartDate(), formatter));
                emp.setNote(employeeDTO.getNote());

                log.info("Updated Employee: {}", emp);
                return ResponseEntity.ok(emp);
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    // Deleting employee details
    public ResponseEntity<String> deleteEmployee(Long id) {
        log.info("Deleting Employee with ID: {}", id);
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id.intValue());
        if (removed) {
            log.info("Employee with ID {} deleted successfully", id);
            return ResponseEntity.ok("Employee deleted successfully for ID: " + id);
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }
}

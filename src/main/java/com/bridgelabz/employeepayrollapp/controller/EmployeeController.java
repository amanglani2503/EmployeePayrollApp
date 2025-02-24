package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {
    @GetMapping
    public String testEndpoint() {
        return "Welcome to Employee Payroll App";
    }
}
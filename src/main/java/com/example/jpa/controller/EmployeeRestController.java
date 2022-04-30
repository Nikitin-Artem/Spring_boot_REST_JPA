package com.example.jpa.controller;

import com.example.jpa.entity.Employee;
import com.example.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // List of all Employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // Searching by Employees by id
    @GetMapping("/employees/{employeeId}")
    public Employee addEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        return employee;
    }

    // Add new Employer
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    // Update existing Employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);

        return employee;
    }

    // Deleting Employer
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}

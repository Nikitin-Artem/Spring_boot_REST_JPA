package com.example.jpa.service;

import com.example.jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee findById(int employeeId);

    public void save(Employee employee);

    public void deleteById(int employeeId);
}

package com.example.jpa.dao;

import com.example.jpa.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getEmployees();

    public Employee findById(int employeeId);

    public void save(Employee employee);

    public void deleteById(int employeeId);
}

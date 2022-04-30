package com.example.jpa.service;

import com.example.jpa.dao.EmployeeDao;
import com.example.jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    @Transactional
    public Employee findById(int employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int employeeId) {
        employeeDao.deleteById(employeeId);
    }
}

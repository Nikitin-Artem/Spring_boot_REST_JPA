package com.example.jpa.dao;

import com.example.jpa.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {
        Query query = entityManager.createQuery("from Employee");

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int employeeId) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", employeeId);

        query.executeUpdate();
    }
}

package com.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    // implement methods
    @Override
    public List<Employee> findAll() {
        // create a query
        List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get employee
        Employee employee = entityManager.find(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save or update the employee
        Employee dbEmployee = entityManager.merge(employee);

        // return the employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find the employee by id
        Employee employee = entityManager.find(Employee.class, id);

        // delete the employee
        entityManager.remove(employee);
    }
}
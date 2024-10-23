package com.springboot.cruddemo.service;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();
}

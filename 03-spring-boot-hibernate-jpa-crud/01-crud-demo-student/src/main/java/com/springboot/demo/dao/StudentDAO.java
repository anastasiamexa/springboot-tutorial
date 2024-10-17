package com.springboot.demo.dao;

import java.util.List;

import com.springboot.demo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();
}

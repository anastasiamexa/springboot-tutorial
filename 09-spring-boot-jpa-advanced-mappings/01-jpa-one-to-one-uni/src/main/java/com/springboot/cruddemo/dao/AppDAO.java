package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}

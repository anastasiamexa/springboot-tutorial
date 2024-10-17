package com.springboot.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // implement findById method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // implement findAll method
    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    // implement findByLastName method
    @Override
    public List<Student> findByLastName(String lastName) {
        return entityManager.createQuery("from Student where lastName=:lastName", Student.class)
                .setParameter("lastName", lastName).getResultList();
    }
}

package com.springboot.cruddemo.dao;

import java.util.List;

import com.springboot.cruddemo.entity.Course;
import com.springboot.cruddemo.entity.Instructor;
import com.springboot.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByJoinFetch(int id);

    void update(Instructor instructor);

    Course findCourseById(int id);

    void update(Course course);

    void deleteInstructorById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseByIdWithReviews(int id);
}

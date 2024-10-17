package com.springboot.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.demo.dao.StudentDAO;
import com.springboot.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating multiple students...");
		Student student1 = new Student("Anastasia", "Mexa", "anastasia@mexa.com");
		Student student2 = new Student("Michael", "Jackson", "michael@jackson.com");
		Student student3 = new Student("Janet", "Jackson", "janet@jackson.com");

		// save the students
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// display the ids of the saved students
		System.out.println("Saved student1 id: " + student1.getId());
		System.out.println("Saved student2 id: " + student2.getId());
		System.out.println("Saved student3 id: " + student3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating a new student...");
		Student student = new Student("John", "Doe", "john@doe.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saved student id: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating a new student...");
		Student student = new Student("David", "Bowie", "david@bowie.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saved student id: " + student.getId());

		// find the student by id
		System.out.println("Finding the student by id...");
		Student foundStudent = studentDAO.findById(student.getId());

		// display the found student
		System.out.println("Found student: " + foundStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> students = studentDAO.findAll();

		// display the students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findByLastName("Jackson");

		// display the students
		for (Student student : students) {
			System.out.println(student);
		}
	}
}

package com.springboot.demo;

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
			createMultipleStudents(studentDAO);
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
}

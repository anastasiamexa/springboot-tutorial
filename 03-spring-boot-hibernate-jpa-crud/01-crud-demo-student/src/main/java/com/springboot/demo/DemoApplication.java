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
			// create a student
			Student student = new Student("John", "Doe", "john@doe.com");

			// save the student
			studentDAO.save(student);

			// display the id of the saved student
			System.out.println("Saved student id: " + student.getId());
		};
	}
}

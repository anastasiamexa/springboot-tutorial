package com.springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.cruddemo.dao.AppDAO;
import com.springboot.cruddemo.entity.Instructor;
import com.springboot.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		/*// Create Instructor
		Instructor instructor = new Instructor("Janet", "Jackson", "janet@jackson.com");

		// Create Instructor Detail
		InstructorDetail instructorDetail = new InstructorDetail("http://www.janet.com/youtube", "Dancing");*/

		// Create Instructor
		Instructor instructor = new Instructor("Michael", "Jackson", "michael@jackson.com");

		// Create Instructor Detail
		InstructorDetail instructorDetail = new InstructorDetail("http://www.michael.com/youtube", "Singing");

		// Associate Instructor with Instructor Detail
		instructor.setInstructorDetail(instructorDetail);

		// Save Instructor
		System.out.println("Saving Instructor: " + instructor);
		appDAO.save(instructor);
	}

	private void findInstructor(AppDAO appDAO) {
		// Find Instructor
		Instructor instructor = appDAO.findById(2);
		System.out.println("Found Instructor: " + instructor);
		System.out.println("Found Instructor Detail: " + instructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDAO appDAO) {
		// Delete Instructor
		appDAO.deleteById(2);
		System.out.println("Instructor Deleted");
	}

	private InstructorDetail findInstructorDetail(AppDAO appDAO) {
		// Find Instructor Detail
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(1);
		System.out.println("Found Instructor Detail: " + instructorDetail);
		System.out.println("Found Instructor: " + instructorDetail.getInstructor());
		return instructorDetail;
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		// Delete Instructor Detail
		appDAO.deleteInstructorDetailById(3);
		System.out.println("Instructor Detail Deleted");
	}
}

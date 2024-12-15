package com.springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.cruddemo.dao.AppDAO;
import com.springboot.cruddemo.entity.Course;
import com.springboot.cruddemo.entity.Instructor;
import com.springboot.cruddemo.entity.InstructorDetail;
import com.springboot.cruddemo.entity.Review;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAndReviews(appDAO);
			retireveCourseAndReviews(appDAO);
		};
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// Create Course
		Course course = new Course("Thriller - Choreography");

		// Create Reviews
		course.addReview(new Review("Awesome"));
		course.addReview(new Review("Amazing!"));
		course.addReview(new Review("Mind-blowing!"));

		// Save Course (this will also save the reviews because of CascadeType.PERSIST)
		System.out.println("Saving Course: " + course);
		System.out.println("Saving Reviews: " + course.getReviews());
		appDAO.save(course);
	}

	private void retireveCourseAndReviews(AppDAO appDAO) {
		// Find Course
		Course course = appDAO.findCourseByIdWithReviews(10);
		System.out.println("Found Course: " + course);
		System.out.println("Found Reviews: " + course.getReviews());
	}

	// ------ OLD CODE ------ //
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

	private void deleteInstructorById(AppDAO appDAO) {
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
		appDAO.deleteInstructorDetailById(4);
		System.out.println("Instructor Detail Deleted");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// Create Instructor
		Instructor instructor = new Instructor("Janet", "Jackson", "janet@jackson.com");

		// Create Instructor Detail
		InstructorDetail instructorDetail = new InstructorDetail("http://www.janet.com/youtube", "Dancing");

		// Associate Instructor with Instructor Detail
		instructor.setInstructorDetail(instructorDetail);

		// Create Courses
		instructor.addCourse(new Course("Rhythm Nation - Choreography"));
		instructor.addCourse(new Course("If - Choreography"));
		instructor.addCourse(new Course("I Get Lonely - Choreography"));

		// Save Instructor (this will also save the courses because of CascadeType.PERSIST)
		System.out.println("Saving Instructor: " + instructor);
		System.out.println("Saving Courses: " + instructor.getCourses());
		appDAO.save(instructor);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// Find Instructor
		Instructor instructor = appDAO.findById(1);
		System.out.println("Found Instructor: " + instructor);
		System.out.println("Found Instructor Detail: " + instructor.getInstructorDetail());
		// Use FetchType.LAZY to load courses
		System.out.println("Found Courses: " + appDAO.findCoursesByInstructorId(1));
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		// Find Instructor
		Instructor instructor = appDAO.findInstructorByJoinFetch(1);
		System.out.println("Found Instructor: " + instructor);
		System.out.println("Found Instructor Detail: " + instructor.getInstructorDetail());
		// Use FetchType.LAZY to load courses
		System.out.println("Found Courses: " + instructor.getCourses());
	}

	private void updateInstructor(AppDAO appDAO) {
		// Find Instructor
		Instructor instructor = appDAO.findById(1);
		System.out.println("Found Instructor: " + instructor);

		// Update Instructor
		instructor.setFirstName("Janet Damita Jo");
		instructor.setLastName("Jackson");
		
		appDAO.update(instructor);
	}

	private void updateCourse(AppDAO appDAO) {
		// Find Course
		Course course = appDAO.findCourseById(10);
		System.out.println("Found Course: " + course);

		// Update Course
		course.setTitle("Nasty - Choreography");
		
		appDAO.update(course);
	}

	private void deleteInstructor(AppDAO appDAO) {
		// Delete Instructor
		appDAO.deleteInstructorById(1);
		System.out.println("Instructor Deleted");
	}

	private void deleteCourseById(AppDAO appDAO) {
		// Delete Course
		appDAO.deleteCourseById(10);
		System.out.println("Course Deleted");
	}
}

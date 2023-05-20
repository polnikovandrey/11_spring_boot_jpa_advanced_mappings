package com.mcfly.crud_demo;

import com.mcfly.crud_demo.dao.AppDAO;
import com.mcfly.crud_demo.entity.Instructor;
import com.mcfly.crud_demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
//		final Instructor instructor
//				= new Instructor("Chad", "Darby", "darby@luv2code.com");
//		final InstructorDetail instructorDetail
//				= new InstructorDetail("https://www.luv2code.com/youtube", "Luv 2 code!!!");
//		instructor.setInstructorDetail(instructorDetail);

		final Instructor instructor
				= new Instructor("Mahdu", "Patel", "madhu@luv2code.com");
		final InstructorDetail instructorDetail
				= new InstructorDetail("https://www.luv2code.com/youtube", "Guitar");
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done saving.");
	}

	private void findInstructor(AppDAO appDAO) {
		final Instructor instructor = appDAO.findById(1);
		final InstructorDetail instructorDetail = instructor.getInstructorDetail();
		System.out.println("Found instructor: " + instructor);
		System.out.println("Found instructor detail: " + instructorDetail);
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteById(2);
		System.out.println("Deleted the instructor.");
	}
}

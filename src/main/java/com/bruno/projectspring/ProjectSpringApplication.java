package com.bruno.projectspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bruno.projectspring.model.Course;
import com.bruno.projectspring.repository.CourseRepository;

@SpringBootApplication
public class ProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository
) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Matemática");
			c.setCategory("exatas");

			courseRepository.save(c);
		};

	}
}

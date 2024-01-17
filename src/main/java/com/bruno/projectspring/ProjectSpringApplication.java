package com.bruno.projectspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bruno.projectspring.enums.Category;
import com.bruno.projectspring.model.Course;
import com.bruno.projectspring.model.Lesson;
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
			c.setName("Redes");
			c.setCategory(Category.REDES);

			Lesson l = new Lesson();
		l.setName("Redes");
		l.setYoutubeUrl("watch?v=sxp3jfaV7TA&list=PLG_7LYUryUI1coU_8JZffCHspvDwZUbcC");
		l.setCourse(c);
		c.getLessons().add(l);

		
		// Lesson l1 = new Lesson();
		// l1.setName("CSS, HTML e JS");
		// l1.setYoutubeUrl("watch?v=-0e-mLEn_ck&list=PLMbclvogjXZWgHgQcY5H4MvKtEW8q53cC");
		// l1.setCourse(c);
		// c.getLessons().add(l1);





			courseRepository.save(c);
		};

		
		
	}
}

package com.lyomann.jdbcexercise;

import com.lyomann.jdbcexercise.dao.DAO;
import com.lyomann.jdbcexercise.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JdbcExerciseApplication {

	private static DAO<Course> dao;

	public JdbcExerciseApplication(DAO<Course> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcExerciseApplication.class, args);

		System.out.println("\n Create course -----------\n");
		Course springVue = new Course("Spring Boot + Vue","New Course","https://www.lyomann.dev/courses");
		dao.create(springVue);

		System.out.println("\n One course ---------------\n");
		Optional<Course> firstOne = dao.get(1);
		System.out.println(firstOne.get());


		springVue.setDescription("Learn to build Vue Apps that talk to spring boot");
		dao.update(springVue, 6);

		dao.delete(4);

		System.out.println("\n All courses -----------\n");
		List<Course> courses = dao.list();
		courses.forEach(System.out::println);


	}

}

package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.*;
import com.hibernate.hibernatejpa.repository.CourseRepository;
import com.hibernate.hibernatejpa.repository.EmployeeRepository;
import com.hibernate.hibernatejpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		employeeRepository.insert(
				new FullTimeEmployee("Jack", new BigDecimal("10000")));

		employeeRepository.insert(
				new PartTimeEmployee("Mike", new BigDecimal("500")));

		logger.info("Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
		logger.info("Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());

//		studentRepository.insertHardcodedStudentAndCourse();
//		Student student = new Student("Elon");
//		Course course = new Course("The Universe");
//		studentRepository.insertStudentAndCourse(student, course);

//		List<Review> reviews = new ArrayList<>();

//		studentRepository.saveStudentWithPassport();

//		Review review1 = new Review("6", "Greate Hands-On");
//		Review review2 = new Review("6", "Hatsoff.");
//
//		reviews.add(review1);
//		reviews.add(review2);
//
//		courseRepository.addReviewsForCourse(101L, reviews);
	}

}

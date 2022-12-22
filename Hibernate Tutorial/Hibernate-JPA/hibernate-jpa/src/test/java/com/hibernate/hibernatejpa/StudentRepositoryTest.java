package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import com.hibernate.hibernatejpa.entity.Passport;
import com.hibernate.hibernatejpa.entity.Student;
import com.hibernate.hibernatejpa.repository.CourseRepository;
import com.hibernate.hibernatejpa.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 201L);
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void someTest() {
        Student student = entityManager.find(Student.class, 201L);
        Passport passport = student.getPassport();
        passport.setNumber("EV21234");
        student.setName("Justin-Updated");
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }


    @Test
    @Transactional
    public void retrievePassportAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 401L);
        logger.info("Student -> {}", passport);
        logger.info("Passport -> {}", passport.getStudent());
    }


    @Test
    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = entityManager.find(Student.class, 201L);
        logger.info("Student -> {}", student);
        logger.info("Courses -> {}", student.getCourses());
    }

    @Test
    @Transactional
    public void readOnlyMethod() {
        Student student = entityManager.find(Student.class, 201L);
        logger.info("Student -> {}", student);
        logger.info("Student Passport -> {}", student.getPassport());
    }


}

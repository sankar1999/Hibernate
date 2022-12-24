package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import com.hibernate.hibernatejpa.entity.Review;
import com.hibernate.hibernatejpa.repository.CourseRepository;
import com.hibernate.hibernatejpa.repository.CourseSpringDataRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseSpringDataRepository repository;

    @Test
    public void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(101L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(101111L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepository() {
//        Course course = new Course("DevOps Tutorial");
//        repository.save(course);
//        course.setName("DevOps Tutorial - Updated");
//        repository.save(course);

        logger.info("Courses -> {}", repository.findAll());
        logger.info("Courses Count -> {}", repository.count());
    }

    @Test
    public void sort() {
//        Sort sort = new Sort(Sort.Direction.ASC, "name");
        logger.info("Courses -> {}", repository.findAll());
        logger.info("Courses Count -> {}", repository.count());
    }

    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("First Page -> {}", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        logger.info("Second Page -> {}", secondPage.getContent());
    }

    @Test
    public void findByName() {
        logger.info("FindByName -> {}", repository.findByName("DevOps Tutorial"));
    }
}

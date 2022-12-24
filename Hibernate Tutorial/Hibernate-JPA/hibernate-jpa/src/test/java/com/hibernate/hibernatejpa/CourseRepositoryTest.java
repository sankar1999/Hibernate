package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import com.hibernate.hibernatejpa.entity.Review;
import com.hibernate.hibernatejpa.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findById_Test() {
        Course course = repository.findById(103L);
        assertEquals("Go", course.getName());
    }

    @Test
//    @Transactional
    public void findById_firstLevelCache() {
        Course course = repository.findById(103L);
        logger.info("First Course Retrieved -> {}", course);

        Course course1 = repository.findById(103L);
        logger.info("First Course Retrieved again -> {}", course1);

        assertEquals("Go", course.getName());
        assertEquals("Go", course1.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_Test() {
        repository.deleteById(105L);
        assertNull(repository.findById(105L));
    }

    @Test
    @DirtiesContext
    public void save_Test() {
        Course course = repository.findById(103L);
        course.setName("Updated");
        repository.save(course);
        Course course1 = repository.findById(103L);
        System.out.println(course1);
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        repository.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(101L);
        logger.info("Course -> {}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = entityManager.find(Review.class,501L);
        logger.info("Review -> {}", review.getCourse());
    }

}

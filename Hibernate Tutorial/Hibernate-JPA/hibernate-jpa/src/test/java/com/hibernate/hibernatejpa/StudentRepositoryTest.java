package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import com.hibernate.hibernatejpa.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;

    @Test
    public void findById_Test() {
        Course course = repository.findById(103L);
        assertEquals("Go", course.getName());
    }

//    @Test
//    @DirtiesContext
//    public void deleteById_Test() {
//        repository.deleteById(103);
//        assertNull(repository.findById(101L));
//    }

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

}

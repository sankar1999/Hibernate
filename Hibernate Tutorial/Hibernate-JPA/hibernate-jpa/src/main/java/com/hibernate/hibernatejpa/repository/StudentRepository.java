package com.hibernate.hibernatejpa.repository;

import com.hibernate.hibernatejpa.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course) {
        if(course.getId()==null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }


    public void playWithEntityManager() {

//        logger.info("PlayWithEntityManager - Start");
//        Course course1 = new Course("Microservices");
//        entityManager.persist(course1);

//        entityManager.clear();

//        Course course2 = new Course("React JS");
//        entityManager.persist(course2);
//        entityManager.flush();

//        entityManager.detach(course2);

//        course1.setName("Microservices-Updated");
//        entityManager.flush();

//        course2.setName("React JS updated");
//        entityManager.flush();

//        entityManager.refresh(course1);

        Course course1 = new Course("American English");
        entityManager.persist(course1);

        Course course2 = findById(101L);
        course2.setName("British English - Updated");
//        entityManager.flush();
    }
}

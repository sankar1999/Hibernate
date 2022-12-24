package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import com.hibernate.hibernatejpa.entity.Student;
import com.hibernate.hibernatejpa.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    public void jpql_basic() {
        Query query = entityManager.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed() {
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course -> {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query =
                entityManager.createNamedQuery("query_get_if_contains_js", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Select c From Course c Where name like '%JS' -> {}", resultList);
    }

    @Test
    public void jpql_courses_without_students() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select c from Course c where c.students is empty",
                        Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_without_atleast_2_students() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select c from Course c where size(c.students) >= 2",
                        Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_orderby_students() {
        TypedQuery<Course> query =
                entityManager.createQuery("Select c from Course c order by size(c.students) desc",
                        Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }


    @Test
    public void jpql_students_with_passports_in_a_certain_pattern() {
        TypedQuery<Student> query =
                entityManager.createQuery("Select s from Student s where s.passport.number like '%123%'",
                        Student.class);
        List<Student> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    @Test
    public void join() {
        Query query =
                entityManager.createQuery("Select c, s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results size -> {}", resultList.size());
        for(Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }


    @Test
    public void left_join() {
        Query query =
                entityManager.createQuery("Select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results size -> {}", resultList.size());
        for(Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }

    @Test
    public void cross_join() {
        Query query =
                entityManager.createQuery("Select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results size -> {}", resultList.size());
        for(Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }
}

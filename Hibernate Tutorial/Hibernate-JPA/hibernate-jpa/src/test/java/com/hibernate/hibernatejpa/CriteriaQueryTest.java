package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import com.hibernate.hibernatejpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    public void all_courses() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        TypedQuery<Course> query =
                entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }


    @Test
    public void all_courses_having_java() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        Predicate likeJava = criteriaBuilder.like(courseRoot.get("name"), "%java");
        criteriaQuery.where(likeJava);

        TypedQuery<Course> query =
                entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void all_courses_without_students() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        Predicate studentsIsEmpty = criteriaBuilder.isEmpty(courseRoot.get("students"));
        criteriaQuery.where(studentsIsEmpty);

        TypedQuery<Course> query =
                entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void join() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        Join<Object, Object> join = courseRoot.join("students");

        TypedQuery<Course> query =
                entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void left_join() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

        Root<Course> courseRoot = criteriaQuery.from(Course.class);

        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

        TypedQuery<Course> query =
                entityManager.createQuery(criteriaQuery.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

}

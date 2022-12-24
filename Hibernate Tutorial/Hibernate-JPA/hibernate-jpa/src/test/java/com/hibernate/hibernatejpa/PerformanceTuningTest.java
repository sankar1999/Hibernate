package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import com.hibernate.hibernatejpa.entity.Review;
import com.hibernate.hibernatejpa.repository.CourseRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;
import org.hibernate.graph.SubGraph;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class PerformanceTuningTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void creatingNPlusOneProblem() {
        List<Course> courses = entityManager
                .createNamedQuery("query_get_all_courses", Course.class)
                .getResultList();
        for (Course course : courses) {
            logger.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    public void solvingNPlusOneProblem_EntityGraph() {
        EntityGraph<Course> entityGraph = entityManager.createEntityGraph(Course.class);
        Subgraph<Object> subgraph = entityGraph.addSubgraph("students");

        List<Course> courses = entityManager
                .createNamedQuery("query_get_all_courses", Course.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
        for (Course course : courses) {
            logger.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    public void creatingNPlusOneProblem_JoinFetch() {
        List<Course> courses = entityManager
                .createNamedQuery("query_get_all_courses_join_fetch", Course.class)
                .getResultList();
        for (Course course : courses) {
            logger.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

}

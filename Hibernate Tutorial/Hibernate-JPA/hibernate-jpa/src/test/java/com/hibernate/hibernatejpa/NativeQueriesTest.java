package com.hibernate.hibernatejpa;

import com.hibernate.hibernatejpa.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = HibernateJpaApplication.class)
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    public void native_queries_basic() {
        Query query = entityManager
                .createNativeQuery("SELECT * FROM COURSE where", Course.class);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}", resultList);
    }

    @Test
    public void native_queries_with_parameter() {
        Query query = entityManager
                .createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
        query.setParameter(1, 101L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE where id = ? -> {}", resultList);
    }


    @Test
    public void native_queries_with_named_parameter() {
        Query query = entityManager
                .createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
        query.setParameter("id", 101L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE where id = :id = ? -> {}", resultList);
    }

    @Test
    @Transactional
    public void native_queries_to_update() {
        Query query = entityManager
                .createNativeQuery("Update Course set last_updated_date = '2022-12-20 02:17:25'");
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
    }

}

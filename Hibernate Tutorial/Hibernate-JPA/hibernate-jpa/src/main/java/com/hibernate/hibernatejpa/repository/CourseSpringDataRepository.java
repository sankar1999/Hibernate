package com.hibernate.hibernatejpa.repository;

import com.hibernate.hibernatejpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> countByName(String name);
    List<Course> findByNameAndId(String name, Long id);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);

    @Query("Select c From Course c where name like '%DevOps'")
    List<Course> coursesWithDevOps();

    @Query(value = "Select * From Course c where name like '%DevOps'", nativeQuery = true)
    List<Course> coursesWithDevOpsUsingNativeQuery();

    @Query(name = "query_get_DevOps_Courses")
    List<Course> coursesWithDevOpsUsingNamedQuery();
}

package com.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(
                new Course(1L, "Advanced Java", "in28minutes"),
                new Course(2L, "Devops", "in28minutes"),
                new Course(3L, "Python programming", "in28minutes")
        );
    }
}

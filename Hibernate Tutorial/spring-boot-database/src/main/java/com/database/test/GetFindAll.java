package com.database.test;

import com.database.entity.Person;
import com.database.jdbc.PersonJdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class GetFindAll {

    @Autowired
    private PersonJdbcDAO personJdbcDAO;

    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson() {
        return personJdbcDAO.findAll();
    }
}

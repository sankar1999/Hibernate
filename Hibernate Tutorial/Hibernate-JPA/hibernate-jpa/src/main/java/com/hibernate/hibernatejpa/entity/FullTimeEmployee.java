package com.hibernate.hibernatejpa.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{
    private BigDecimal salary;

    public FullTimeEmployee() {}

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    
}

package com.hibernate.hibernatejpa.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;
    private String description;

    @ManyToOne
    private Course course;

    public Review() {
    }

    public Review(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Review(String rating ,String description) {
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]", rating, description);
    }
}

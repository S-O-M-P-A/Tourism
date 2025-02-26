package com.example.Project_tour.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewername;
    private String text;
    private String reviewdate;
    private String rating;

    @ManyToMany(mappedBy = "reviews", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Admin> admins = new ArrayList<Admin>();

    @ManyToMany(mappedBy = "reviews", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Registration> registrations = new ArrayList<Registration>();

    public Reviews() {
    }

    public Reviews(String reviewername, String text, String reviewdate, String rating, List<Admin> admins, List<Registration> registrations) {
        this.reviewername = reviewername;
        this.text = text;
        this.reviewdate = reviewdate;
        this.rating = rating;
        this.admins = admins;
        this.registrations = registrations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewername() {
        return reviewername;
    }

    public void setReviewername(String reviewername) {
        this.reviewername = reviewername;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(String reviewdate) {
        this.reviewdate = reviewdate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}

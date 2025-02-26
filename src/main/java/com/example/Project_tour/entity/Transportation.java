package com.example.Project_tour.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String fear;
    private String capacity;
    private String startingpoint;
    private String destination;

    @ManyToMany(mappedBy = "transportation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Registration> registration = new ArrayList<Registration>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "connectsto",
            joinColumns = @JoinColumn(name = "transportation_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id"))
    private List<Place> place = new ArrayList<Place>();

    public Transportation() {
    }

    public Transportation(String type, String fear, String capacity, String startingpoint, String destination, List<Registration> registration, List<Place> place) {
        this.type = type;
        this.fear = fear;
        this.capacity = capacity;
        this.startingpoint = startingpoint;
        this.destination = destination;
        this.registration = registration;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFear() {
        return fear;
    }

    public void setFear(String fear) {
        this.fear = fear;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStartingpoint() {
        return startingpoint;
    }

    public void setStartingpoint(String startingpoint) {
        this.startingpoint = startingpoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }
}

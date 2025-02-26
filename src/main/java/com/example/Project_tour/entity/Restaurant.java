package com.example.Project_tour.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contactno;
    private int rating;
    private int capacity;
    private String cuisinetype;
    private String specialfeature;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToMany(mappedBy = "restaurants", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Registration> registrations = new ArrayList<Registration>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "has",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "menuitem_id"))
    private List<MenuItems> menuItems = new ArrayList<MenuItems>();

    public Restaurant() {
    }

    public Restaurant(String name, String address, String contactno, int rating, int capacity, String cuisinetype, String specialfeature, Place place, List<Registration> registrations, List<MenuItems> menuItems) {
        this.name = name;
        this.address = address;
        this.contactno = contactno;
        this.rating = rating;
        this.capacity = capacity;
        this.cuisinetype = cuisinetype;
        this.specialfeature = specialfeature;
        this.place = place;
        this.registrations = registrations;
        this.menuItems = menuItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCuisinetype() {
        return cuisinetype;
    }

    public void setCuisinetype(String cuisinetype) {
        this.cuisinetype = cuisinetype;
    }

    public String getSpecialfeature() {
        return specialfeature;
    }

    public void setSpecialfeature(String specialfeature) {
        this.specialfeature = specialfeature;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<MenuItems> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }
}

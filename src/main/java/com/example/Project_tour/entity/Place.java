package com.example.Project_tour.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placeName;
    public String division;
    public String district;
    public String upazila;
    public String road;
    public String history;
    public String description;
    public String type;
    public String map;
    public String visittime;
    public String localcuisine;
    public String gallery;
    public String wildlifeandnaturalfeature;
    public String visitorcount;

    @ManyToMany(mappedBy = "places", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Registration> registration = new ArrayList<Registration>();

    @ManyToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transportation> transportation = new ArrayList<Transportation>();

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hotels> hotels = new ArrayList<Hotels>();

    @ManyToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Admin> admins = new ArrayList<Admin>();

    public Place() {
    }

    public Place(String placeName, String division, String district, String upazila, String road, String history, String description, String type, String map, String visittime, String localcuisine, String gallery, String wildlifeandnaturalfeature, String visitorcount, List<Registration> registration, List<Transportation> transportation, List<Restaurant> restaurants, List<Hotels> hotels, List<Admin> admins) {
        this.placeName = placeName;
        this.division = division;
        this.district = district;
        this.upazila = upazila;
        this.road = road;
        this.history = history;
        this.description = description;
        this.type = type;
        this.map = map;
        this.visittime = visittime;
        this.localcuisine = localcuisine;
        this.gallery = gallery;
        this.wildlifeandnaturalfeature = wildlifeandnaturalfeature;
        this.visitorcount = visitorcount;
        this.registration = registration;
        this.transportation = transportation;
        this.restaurants = restaurants;
        this.hotels = hotels;
        this.admins = admins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpazila() {
        return upazila;
    }

    public void setUpazila(String upazila) {
        this.upazila = upazila;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public String getLocalcuisine() {
        return localcuisine;
    }

    public void setLocalcuisine(String localcuisine) {
        this.localcuisine = localcuisine;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getWildlifeandnaturalfeature() {
        return wildlifeandnaturalfeature;
    }

    public void setWildlifeandnaturalfeature(String wildlifeandnaturalfeature) {
        this.wildlifeandnaturalfeature = wildlifeandnaturalfeature;
    }

    public String getVisitorcount() {
        return visitorcount;
    }

    public void setVisitorcount(String visitorcount) {
        this.visitorcount = visitorcount;
    }

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }

    public List<Transportation> getTransportation() {
        return transportation;
    }

    public void setTransportation(List<Transportation> transportation) {
        this.transportation = transportation;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}


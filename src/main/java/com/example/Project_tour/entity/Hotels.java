package com.example.Project_tour.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contactno;
    private int rating;
    private String prizerange;
    private String amnities;
    private String roomtype;
    private int numberofrooms;
    private String availability;
    private String checkintimes;
    private String checkouttimes;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToMany(mappedBy = "hotels", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Registration> registrations = new ArrayList<Registration>();

}

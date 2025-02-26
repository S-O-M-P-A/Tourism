package com.example.Project_tour.repository;

import com.example.Project_tour.entity.Admin;
import com.example.Project_tour.entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation,Long> {


}


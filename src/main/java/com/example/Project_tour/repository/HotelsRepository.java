package com.example.Project_tour.repository;

import com.example.Project_tour.entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels,Long> {

}


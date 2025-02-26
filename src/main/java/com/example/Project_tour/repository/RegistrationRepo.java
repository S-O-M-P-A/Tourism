package com.example.Project_tour.repository;

import com.example.Project_tour.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    public Registration findByEmailAndPassword(String email,String password);
}
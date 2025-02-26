package com.example.Project_tour.service;

import com.example.Project_tour.entity.Registration;
import com.example.Project_tour.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    public Registration login(String emailHtml,String password) {
        Registration registrationFromDB = registrationRepo.findByEmailAndPassword(emailHtml, password);
        return registrationFromDB;
    }

    public void saveInfo(Registration registration){
        System.out.println("Accessed...");
        registrationRepo.save(registration);
    }
}

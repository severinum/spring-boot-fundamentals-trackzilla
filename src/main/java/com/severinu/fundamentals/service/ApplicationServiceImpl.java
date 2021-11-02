package com.severinu.fundamentals.service;

import com.severinu.fundamentals.entity.Application;
import com.severinu.fundamentals.exceptions.ApplicationNotFoundException;
import com.severinu.fundamentals.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if(optionalApplication.isPresent())
            return optionalApplication.get();
        else {
            System.out.println("Can't find Application with ID: " + id);
            throw new ApplicationNotFoundException("Application not found", id);
        }
    }
}

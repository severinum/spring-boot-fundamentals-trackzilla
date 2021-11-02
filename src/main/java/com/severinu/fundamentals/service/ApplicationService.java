package com.severinu.fundamentals.service;

import com.severinu.fundamentals.entity.Application;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ApplicationService {

    List<Application> listApplications();
    Application findApplication(long id);
}

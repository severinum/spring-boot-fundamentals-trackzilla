package com.severinu.fundamentals.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.severinu.fundamentals.entity.Application;
import com.severinu.fundamentals.exceptions.ApplicationNotFoundException;
import com.severinu.fundamentals.repository.ApplicationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final ApplicationRepository applicationRepository;


    public Mutation(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application newApplication(
            String name,
            String owner,
            String description) {
        Application app = new Application(name, owner, description);
        applicationRepository.save(app);
        return app;
    }

    public boolean deleteApplication(Long id) {
        applicationRepository.deleteById(id);
        return true;
    }

    public Application updateApplicationOwner(String newOwner, Long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if(optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setOwner(newOwner);
            applicationRepository.save(application);
            return application;
        }
        else
            throw new ApplicationNotFoundException("Application Not Found", id);
    }

    public Application updateApplicationName(String newName, Long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if(optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setName(newName);
            applicationRepository.save(application);
            return application;
        }
        else
            throw new ApplicationNotFoundException("Application Not Found", id);
    }
}


























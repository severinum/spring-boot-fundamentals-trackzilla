package com.severinu.fundamentals.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.severinu.fundamentals.entity.Application;
import com.severinu.fundamentals.repository.ApplicationRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {


    private ApplicationRepository applicationRepository;

    public Query(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Iterable<Application> findAllApplications() {
        return applicationRepository.findAll();
    }

    public long countApplications () {
        return applicationRepository.count();
    }

}

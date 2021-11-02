package com.severinu.fundamentals.rest;

import com.severinu.fundamentals.entity.Application;
import com.severinu.fundamentals.entity.Ticket;
import com.severinu.fundamentals.exceptions.ApplicationNotFoundException;
import com.severinu.fundamentals.service.ApplicationService;
import com.severinu.fundamentals.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tza")
public class TzaRestController {

    private final ApplicationService applicationService;
    private final TicketService ticketService;


    public TzaRestController(ApplicationService applicationService, TicketService ticketService) {
        this.applicationService = applicationService;
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets () {
        List<Ticket> list = ticketService.listTickets();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> list = applicationService.listApplications();
        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplication (@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(applicationService.findApplication(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
        }
    }
}

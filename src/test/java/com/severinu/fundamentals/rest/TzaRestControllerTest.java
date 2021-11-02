package com.severinu.fundamentals.rest;

import com.severinu.fundamentals.service.ApplicationService;
import com.severinu.fundamentals.service.ReleaseService;
import com.severinu.fundamentals.service.TicketService;
import com.severinu.fundamentals.web.TzaController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TzaRestController.class)
public class TzaRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApplicationService applicationService;

    @MockBean
    TicketService ticketService;

    @MockBean
    ReleaseService releaseService;

    @Test
    public void getAllApplications() throws Exception {
        mockMvc.perform(get("/tza/applications/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(applicationService, times(1)).listApplications();
    }

}
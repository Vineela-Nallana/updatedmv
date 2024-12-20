package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.model.MovieTicket;
import com.example.movieticketbooking.workflow.MovieTicketWorkflow;
import com.example.movieticketbooking.workflow.MovieTicketWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private WorkflowClient workflowClient;

    @PostMapping("/book")
    public String bookTicket(@RequestBody MovieTicket ticket) {
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue("movie-ticket-queue")
                .build();

        MovieTicketWorkflow workflow = workflowClient.newWorkflowStub(MovieTicketWorkflow.class, options);

        WorkflowClient.start(workflow::bookTicket, ticket);
        return "Ticket booking workflow started for movie: " + ticket.getMovieName();
    }
}

//package com.example.movieticketbooking.controller;
//
//import com.example.movieticketbooking.model.MovieTicket;
//import com.example.movieticketbooking.service.MovieTicketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/ticket-booking")
//public class TicketBookingController {
//
//    @Autowired
//    private MovieTicketService movieTicketService;
//
//    @PostMapping("/book")
//    public String bookTicket(@RequestBody MovieTicket ticket) {
//        return movieTicketService.bookMovieTicket(ticket);
//    }
//}
//
//
//

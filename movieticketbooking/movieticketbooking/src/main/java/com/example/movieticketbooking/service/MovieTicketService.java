package com.example.movieticketbooking.service;

import com.example.movieticketbooking.model.MovieTicket;
import com.example.movieticketbooking.workflow.MovieTicketWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketService {

    @Autowired
    private WorkflowClient workflowClient;

    public String bookMovieTicket(MovieTicket ticket) {
        // Create a workflow stub with the task queue name
        MovieTicketWorkflow workflowStub = workflowClient.newWorkflowStub(
                MovieTicketWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("movie-ticket-queue")
                        .build()
        );

        // Start the workflow execution
        workflowStub.processBooking(ticket);

        return "Ticket booking process started for " + ticket.getMovieName() + " at " + ticket.getTheatreName();
    }
}

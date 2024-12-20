package com.example.movieticketbooking.workflow;

import com.example.movieticketbooking.activities.MovieTicketActivities;
import com.example.movieticketbooking.model.MovieTicket;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class MovieTicketWorkflowImpl implements MovieTicketWorkflow {

    private final MovieTicketActivities activities;

    public MovieTicketWorkflowImpl() {
        ActivityOptions options = ActivityOptions.newBuilder()
                .setScheduleToCloseTimeout(Duration.ofMinutes(5))
                .build();
        this.activities = Workflow.newActivityStub(MovieTicketActivities.class, options);
    }

    @Override
    public String processBooking(MovieTicket ticket) {
        try {
            activities.reserveSeat(ticket);

            if (activities.paymentProcessing(ticket)) {
                activities.updateInventory(ticket);
                activities.sendConfirmation(ticket);
                return "Booking confirmed for movie: " + ticket.getMovieName();
            } else {
                activities.releaseSeat(ticket);
                return "Booking failed for movie: " + ticket.getMovieName();
            }
        } catch (Exception e) {
            System.out.println("Error processing booking: " + e.getMessage());
            activities.releaseSeat(ticket);
            return "Booking failed due to an error.";
        }
    }
}
//package com.example.movieticketbooking.workflow;
//
//import com.example.movieticketbooking.activities.MovieTicketActivities;
//import com.example.movieticketbooking.model.MovieTicket;
//import io.temporal.activity.ActivityOptions;
//import io.temporal.workflow.Workflow;
//
//import java.time.Duration;
//
//public class MovieTicketWorkflowImpl implements MovieTicketWorkflow {
//
//    // Define ActivityOptions for the activity stub
//    private final MovieTicketActivities activities = Workflow.newActivityStub(
//            MovieTicketActivities.class,
//            ActivityOptions.newBuilder()
//                    .setStartToCloseTimeout(Duration.ofMinutes(2))
//                    .build()
//    );
//
//    @Override
//    public void bookTicket(MovieTicket ticket) {
//        try {
//            // Reserve the seat
//            activities.reserveSeat(ticket);
//
//            // Process payment
//            boolean paymentSuccessful = activities.paymentProcessing(ticket);
//            if (!paymentSuccessful) {
//                activities.releaseSeat(ticket);
//                return;
//            }
//
//            // Update inventory
//            activities.updateInventory(ticket);
//
//            // Send confirmation
//            activities.sendConfirmation(ticket);
//
//        } catch (Exception e) {
//            System.out.println("Error during booking process: " + e.getMessage());
//        }
//    }
//}




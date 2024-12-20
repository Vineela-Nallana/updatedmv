package com.example.movieticketbooking.activities;

import com.example.movieticketbooking.model.Inventory;
import com.example.movieticketbooking.model.MovieTicket;
import com.example.movieticketbooking.repository.InventoryRepository;
import com.example.movieticketbooking.repository.MovieTicketRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.logging.Logger;

@Component
public class MovieTicketActivitiesImpl implements MovieTicketActivities {

    private static final Logger logger = Logger.getLogger(MovieTicketActivitiesImpl.class.getName());

    private final MovieTicketRepository ticketRepository;
    private final InventoryRepository inventoryRepository;

    // Constructor Injection - Spring will automatically inject the required repositories
    public MovieTicketActivitiesImpl(MovieTicketRepository ticketRepository, InventoryRepository inventoryRepository) {
        this.ticketRepository = ticketRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void reserveSeat(MovieTicket ticket) {
        MovieTicket existingTicket = ticketRepository.findByMovieTheatreAndSeat(
                ticket.getMovieName(), ticket.getTheatreName(), ticket.getSeatNumber()
        );

        if (existingTicket != null && "Seat Reserved".equals(existingTicket.getPaymentStatus())) {
            throw new IllegalStateException("Seat is already reserved.");
        }

        ticket.setPaymentStatus("Seat Reserved");
        ticket.setBookingTimestamp(Instant.now().toString());
        ticketRepository.save(ticket);

        logger.info("Seat reserved successfully for movie: " + ticket.getMovieName() + ", Seat: " + ticket.getSeatNumber());
    }

    @Override
    public boolean paymentProcessing(MovieTicket ticket) {
        boolean paymentSuccessful = Math.random() > 0.2; // 80% chance of success
        ticket.setPaymentStatus(paymentSuccessful ? "Payment Successful" : "Payment Failed");
        ticketRepository.save(ticket);

        logger.info("Payment " + (paymentSuccessful ? "successful" : "failed") +
                " for movie: " + ticket.getMovieName() + ", Seat: " + ticket.getSeatNumber());
        return paymentSuccessful;
    }

    @Override
    public void releaseSeat(MovieTicket ticket) {
        ticket.setPaymentStatus("Seat Released");
        ticketRepository.save(ticket);

        logger.info("Seat released for movie: " + ticket.getMovieName() + ", Seat: " + ticket.getSeatNumber());
    }

    @Override
    public void updateInventory(MovieTicket ticket) {
        Inventory inventory = inventoryRepository.findByMovieAndTheatre(ticket.getMovieName(), ticket.getTheatreName());

        if (inventory != null && inventory.getAvailableSeats() > 0) {
            inventory.setAvailableSeats(inventory.getAvailableSeats() - 1);
            inventoryRepository.save(inventory);

            logger.info("Inventory updated: Available seats decreased for movie: " +
                    ticket.getMovieName() + ", Theatre: " + ticket.getTheatreName());
        } else {
            throw new IllegalStateException("No seats available for movie: " + ticket.getMovieName());
        }
    }

    @Override
    public void sendConfirmation(MovieTicket ticket) {
        ticket.setPaymentStatus("Booking Confirmed");
        ticketRepository.save(ticket);

        logger.info("Confirmation sent for movie: " + ticket.getMovieName() +
                ", Seat: " + ticket.getSeatNumber());
    }
}



//package com.example.movieticketbooking.activities;
//
//import com.example.movieticketbooking.model.MovieTicket;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MovieTicketActivitiesImpl implements MovieTicketActivities {
//
//    @Override
//    public void reserveSeat(MovieTicket ticket) {
//        // Simulate seat reservation
//        System.out.println("Reserving seat: " + ticket.getSeatNumber() + " for movie: " + ticket.getMovieName());
//        ticket.setPaymentStatus("Seat Reserved");
//    }
//
//    @Override
//    public boolean paymentProcessing(MovieTicket ticket) {
//        // Simulate payment processing logic
//        System.out.println("Processing payment for ticket: " + ticket);
//        boolean paymentSuccessful = Math.random() > 0.2; // Simulate 80% success rate
//        ticket.setPaymentStatus(paymentSuccessful ? "Payment Successful" : "Payment Failed");
//        return paymentSuccessful;
//    }
//
//    @Override
//    public void releaseSeat(MovieTicket ticket) {
//        // Simulate seat release on payment failure
//        System.out.println("Releasing seat: " + ticket.getSeatNumber() + " for movie: " + ticket.getMovieName());
//        ticket.setPaymentStatus("Seat Released");
//    }
//
//    @Override
//    public void updateInventory(MovieTicket ticket) {
//        // Simulate inventory update
//        System.out.println("Updating inventory for seat: " + ticket.getSeatNumber() + " for movie: " + ticket.getMovieName());
//    }
//
//    @Override
//    public void sendConfirmation(MovieTicket ticket) {
//        // Simulate sending confirmation to the user
//        System.out.println("Sending confirmation for ticket: " + ticket);
//    }
//}

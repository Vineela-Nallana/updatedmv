package com.example.movieticketbooking.activities;

import com.example.movieticketbooking.model.MovieTicket;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface MovieTicketActivities {

    @ActivityMethod
    void reserveSeat(MovieTicket ticket);

    @ActivityMethod
    boolean paymentProcessing(MovieTicket ticket);

    @ActivityMethod
    void releaseSeat(MovieTicket ticket);

    @ActivityMethod
    void updateInventory(MovieTicket ticket);

    @ActivityMethod
    void sendConfirmation(MovieTicket ticket);
}

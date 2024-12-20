package com.example.movieticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApplication.class, args);
		System.out.println("Movie Ticket Booking Application is running...");
	}
}
//package com.example.movieticketbooking;
//
//import io.temporal.worker.WorkerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class MovieTicketBookingApplication implements CommandLineRunner {
//
//	private final WorkerFactory workerFactory;
//
//	@Autowired
//	public MovieTicketBookingApplication(WorkerFactory workerFactory) {
//		this.workerFactory = workerFactory;
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(MovieTicketBookingApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) {
//		// Start Temporal worker to listen on the configured task queue
//		workerFactory.start();
//		System.out.println("Worker started and listening on the Task Queue...");
//	}
//}




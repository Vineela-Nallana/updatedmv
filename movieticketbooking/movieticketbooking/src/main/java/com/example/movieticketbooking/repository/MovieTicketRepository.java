package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.model.MovieTicket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTicketRepository extends MongoRepository<MovieTicket, String> {
}
//package com.example.movieticketbooking.repository;
//
//import com.example.movieticketbooking.model.MovieTicket;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface MovieTicketRepository extends MongoRepository<MovieTicket, String> {
//    @Query("{'movieName': ?0, 'theatreName': ?1, 'seatNumber': ?2}")
//    MovieTicket findByMovieTheatreAndSeat(String movieName, String theatreName, String seatNumber);
//}


//package com.example.movieticketbooking.repository;
//
//import com.example.movieticketbooking.model.MovieTicket;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface MovieTicketRepository extends JpaRepository<MovieTicket, Long> {
//    MovieTicket findByMovieTheatreAndSeat(String movieName, String theatreName, String seatNumber);
//}


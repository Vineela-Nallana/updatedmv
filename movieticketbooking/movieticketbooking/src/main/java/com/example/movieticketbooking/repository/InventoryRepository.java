package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
    @Query("{'movieName': ?0, 'theatreName': ?1}")
    Inventory findByMovieAndTheatre(String movieName, String theatreName);
}

package com.example.localibback.rentals;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentalRepository extends MongoRepository<Rental, String> {
}

package com.example.localibback.vehicules;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculeRepository extends MongoRepository<Vehicule, String> {
}

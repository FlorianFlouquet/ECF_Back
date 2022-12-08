package com.example.localibback.rentals;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Rental save(Rental entity) {
        return rentalRepository.save(entity);
    }

    public Rental findById(String id) {
        return rentalRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    public void deleteById(String id) {
        rentalRepository.deleteById(id);
    }
}

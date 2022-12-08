package com.example.localibback.vehicules;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    public Vehicule save(Vehicule entity) {
        return vehiculeRepository.save(entity);
    }

    public Vehicule findById(String id) {
        return vehiculeRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    public void deleteById(String id) {
        vehiculeRepository.deleteById(id);
    }
}

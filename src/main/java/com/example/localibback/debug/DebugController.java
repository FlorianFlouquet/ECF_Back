package com.example.localibback.debug;

import com.example.localibback.rentals.RentalRepository;
import com.example.localibback.users.UserRepository;
import com.example.localibback.vehicles.VehicleRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("debug")
public class DebugController {
    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;

    public DebugController(RentalRepository rentalRepository, UserRepository userRepository, VehicleRepository vehicleRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }

    private final VehicleRepository vehicleRepository;

    @DeleteMapping ("all")
    public void deleteAll() {
        this.rentalRepository.deleteAll();
        this.userRepository.deleteAll();
        this.vehicleRepository.deleteAll();
    }
}

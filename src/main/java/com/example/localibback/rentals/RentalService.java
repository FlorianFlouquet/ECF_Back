package com.example.localibback.rentals;

import com.example.localibback.vehicles.Vehicle;
import com.example.localibback.vehicles.VehicleRepository;
import com.example.localibback.vehicles.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

public class RentalService {
    private Logger logger = LoggerFactory.getLogger(RentalService.class);
    private final RentalRepository rentalRepository;
    private final VehicleService vehicleService;

    public RentalService(RentalRepository rentalRepository, VehicleService vehicleService) {
        this.rentalRepository = rentalRepository;
        this.vehicleService = vehicleService;
    }

    /**
     * Find and return all rentals
     * @return
     */
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    /**
     * Change the selected vehicle disponibility to false, then save the rental to the DB
     * @param entity
     * @return
     */
    public Rental save(Rental entity) {
        // Check if the rental start date is before its end date
        if(entity.getDateStart().isBefore(entity.getDateEnd())) {
            // Get all rentals documents from the database with the same vehicle_id as the entity (parameter)
            List<Rental> rentals = this.rentalRepository.findRentalsByVehicleId(entity.getVehicle().getId());
            logger.warn(rentals.toString());
            // Check for the vehicle's availability
            if(this.checkAvailability(rentals, entity.getDateStart(), entity.getDateEnd())) {
                Vehicle vehicle = this.vehicleService.findById(entity.getVehicle().getId());
                vehicle.setAvailable(false);
                vehicleService.update(vehicle, vehicle.getId());
                entity.setVehicle(vehicle);
                logger.info("The rental has successfully been created : " + entity.toString());
                return rentalRepository.save(entity);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
            }
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * Check if a vehicle is available between two dates. If its available returns true, otherwise returns false
     * @return
     */
    public boolean checkAvailability(List<Rental> rentals, LocalDate dateStart, LocalDate dateEnd) {
        for (Rental rental : rentals) {
            if(dateStart.isAfter(rental.getDateStart()) && dateStart.isBefore(rental.getDateEnd())) {
                return false;
            } else if (dateEnd.isAfter(rental.getDateStart()) && dateEnd.isBefore(rental.getDateEnd())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find a rental by its id
     * @param id
     * @return
     */
    public Rental findById(String id) {
        return rentalRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Delete a rental by its id
     * @param id
     */
    public void deleteById(String id) {
        rentalRepository.deleteById(id);
    }
}

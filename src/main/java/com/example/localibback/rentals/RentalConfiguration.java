package com.example.localibback.rentals;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RentalConfiguration {
    @Bean
    public RentalService rentalService(RentalRepository rentalRepository) {
        return new RentalService(rentalRepository);
    }
}

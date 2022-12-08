package com.example.localibback.rentals;

import com.example.localibback.users.User;
import com.example.localibback.vehicules.Vehicule;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Document
@Data
public class Rental {
    @Id
    private String id;
    @DBRef
    private User renter;
    @DBRef
    private Vehicule vehicule;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;

    public double getTotalPrice() {
        Period period = Period.between(this.dateStart, this.dateEnd);
        return period.getDays() * this.getVehicule().getPrice();
    }
}
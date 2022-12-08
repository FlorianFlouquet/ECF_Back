package com.example.localibback.vehicles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    private String id;
    private String brand;
    private String model;
    private String state;
    private String license_number;
    private String type;
    private Double price;
    private boolean available;
}

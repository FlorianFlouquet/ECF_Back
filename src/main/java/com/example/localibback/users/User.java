package com.example.localibback.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class User {
    @Id
    private String id;
    private String surname;
    private String firstname;
    @JsonFormat(pattern = "yyyy-MM-d")
    private LocalDate birthDate;
    private String email;
    private int phoneNumber;
}

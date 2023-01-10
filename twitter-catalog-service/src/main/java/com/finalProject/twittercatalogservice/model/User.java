package com.finalProject.twittercatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends Account {
    private String username;
    private LocalDate birthDate;
    //country save in the db as country alpha3Code
    private String bio;
}


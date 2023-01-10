package com.finalProject.accountdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "account_id")
public class User extends Account {
    @NotEmpty(message = "Username can not be empty")
    private String username;
    @NotNull(message = "Date of birth cannot be null")
    @PastOrPresent
    private LocalDate birthDate;
    private String bio;

    public void setBirthDate(LocalDate birthDate) {
        if( Period.between(birthDate, LocalDate.now()).getYears() >= 18)
            this.birthDate = birthDate;
        else
            throw new IllegalArgumentException("Your age should not be less than 18");
    }
}


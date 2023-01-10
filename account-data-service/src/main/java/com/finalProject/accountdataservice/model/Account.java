package com.finalProject.accountdataservice.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "account_id")
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;
    @NotEmpty(message = "Name can not be empty")
    @Pattern(regexp = "[a-zA-Z]*$", message = "Name must contain only valid characters")
    private String name;
    private String profileImg = "https://pbs.twimg.com/profile_images/1012362101510160384/EjayQ10E_400x400.jpg";
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Password can not be empty")
    private String password;
    private LocalDate creationDate = LocalDate.now();
}

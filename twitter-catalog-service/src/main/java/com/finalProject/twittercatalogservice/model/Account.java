package com.finalProject.twittercatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {
    private Long account_id;
    private String name;
    private String profileImg = "https://pbs.twimg.com/profile_images/1012362101510160384/EjayQ10E_400x400.jpg";
    private String email;
    private String password;
    private LocalDate creationDate = LocalDate.now();
}

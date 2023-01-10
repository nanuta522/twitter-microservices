package com.finalProject.twittercatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
    private Long tweet_id;
    private Long userId;
    private User user;
    private String message;
    //list of user_id whose like the tweet
    private Set<Long> userLikes;
    private Tweet parentTweet;
    private LocalDate timeStamp = LocalDate.now();
    private Integer numComments = 0;
}

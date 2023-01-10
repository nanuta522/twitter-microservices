package com.finalProject.tweetdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweet_id;
    private Long userId;
    @Size(max = 140, message = "Message must be less than 140 characters")
    private String message;
    //list of user_id whose like the tweet
    @ElementCollection
    @CollectionTable(name = "userLikes", joinColumns = @JoinColumn(name = "tweet_id"))
    @Column(name = "user_id")
    private Set<Long> userLikes;
    @ManyToOne
    @JoinColumn(name="parentTweetId")
    private Tweet parentTweet;
    private LocalDate timeStamp = LocalDate.now();
}

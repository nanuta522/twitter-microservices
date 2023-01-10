package com.finalProject.tweetdataservice.controller.interfaces;

import com.finalProject.tweetdataservice.model.Tweet;

import java.util.List;
import java.util.Set;

public interface ITweetController {
    Tweet createTweet(Tweet tweet);
    List<Tweet> getAllTweets();
    Tweet getTweetById(Long tweet_id);
    List<Tweet> getTweetsByUser(Long user_id);

    Tweet likeTweet(Long user_id, Long tweet_id);
    List<Tweet> getTweetsLikedByUser(Long user_id);

    Tweet addComment(Long tweet_id, Tweet tweet);
    List<Tweet> getTweetComments(Long tweet_id);
    void deleteTweet(Long tweet_id);
}

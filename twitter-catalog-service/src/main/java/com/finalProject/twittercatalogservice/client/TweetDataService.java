package com.finalProject.twittercatalogservice.client;

import com.finalProject.twittercatalogservice.model.Tweet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("tweet-data-service")
public interface TweetDataService {
    @PostMapping("/api/tweet")
    public Tweet createTweet(@RequestBody Tweet tweet);

    @GetMapping("/api/tweet/all")
    public List<Tweet> getAllTweets();

    @GetMapping("/api/tweet/{tweet_id}")
    public Tweet getTweetById(@PathVariable Long tweet_id);

    @GetMapping("/api/tweet/user/{user_id}")
    public List<Tweet> getTweetsByUser(@PathVariable Long user_id);

    @PutMapping("/api/tweet/add-like/{user_id}/{tweet_id}")
    public Tweet likeTweet(@PathVariable Long user_id, @PathVariable Long tweet_id);

    @GetMapping("/api/tweet/likes/{user_id}")
    public List<Tweet> getTweetsLikedByUser(@PathVariable Long user_id);

    @PutMapping("/api/tweet/add-comment/{tweet_id}")
    public Tweet addComment(@PathVariable Long tweet_id, @RequestBody Tweet tweet);

    @GetMapping("/api/tweet/comments/{parent_tweet_id}")
    public List<Tweet> getTweetComments(@PathVariable Long parent_tweet_id);

    @DeleteMapping("/api/tweet/{tweet_id}")
    public void deleteTweet(@PathVariable Long tweet_id);
}

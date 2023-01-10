package com.finalProject.tweetdataservice.controller.impl;

import com.finalProject.tweetdataservice.controller.interfaces.ITweetController;
import com.finalProject.tweetdataservice.model.Tweet;
import com.finalProject.tweetdataservice.service.impl.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tweet")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
public class TweetController implements ITweetController {
    @Autowired
    TweetService tweetService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Tweet createTweet(@RequestBody @Valid Tweet tweet) {
        return tweetService.createTweet(tweet);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getAllTweets() {
        return tweetService.getAllTweets();
    }

    @GetMapping("/{tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public Tweet getTweetById(@PathVariable Long tweet_id) {
        return tweetService.getTweetById(tweet_id);
    }

    @GetMapping("/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getTweetsByUser(@PathVariable Long user_id) {
        return tweetService.getTweetsByUser(user_id);
    }

    @PutMapping("/add-like/{user_id}/{tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public Tweet likeTweet(@PathVariable Long user_id, @PathVariable Long tweet_id) {
        return tweetService.likeTweet(user_id, tweet_id);
    }

    @GetMapping("/likes/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getTweetsLikedByUser(@PathVariable Long user_id) {
        return tweetService.getTweetsLikedByUser(user_id);
    }

    @PutMapping("/add-comment/{tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public Tweet addComment(@PathVariable Long tweet_id, @RequestBody @Valid Tweet tweet) {
        return tweetService.addComment(tweet_id, tweet);
    }

    @GetMapping("/comments/{parent_tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getTweetComments(@PathVariable Long parent_tweet_id) {
        return tweetService.getTweetComments(parent_tweet_id);
    }

    @DeleteMapping("/{tweet_id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Tweet successfully deleted")
    public void deleteTweet(@PathVariable Long tweet_id) {
        tweetService.deleteTweet(tweet_id);
    }
}

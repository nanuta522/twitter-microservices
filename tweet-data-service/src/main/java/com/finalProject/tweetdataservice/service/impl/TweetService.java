package com.finalProject.tweetdataservice.service.impl;

import com.finalProject.tweetdataservice.model.Tweet;
import com.finalProject.tweetdataservice.repository.TweetRepository;
import com.finalProject.tweetdataservice.service.interfaces.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;


@Service
public class TweetService implements ITweetService {
    @Autowired
    TweetRepository tweetRepository;

    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    public Tweet getTweetById(Long tweet_id) {
        Optional<Tweet> tweetOptional = tweetRepository.findById(tweet_id);
        if (tweetOptional.isPresent()) return tweetOptional.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tweet not found");
    }

    public List<Tweet> getTweetsByUser(Long user_id) {
        return tweetRepository.findAllByUserIdEquals(user_id);
    }

    public Tweet likeTweet(Long user_id, Long tweet_id) {
        Optional<Tweet> tweetOptional = tweetRepository.findById(tweet_id);
        if (tweetOptional.isPresent()) {
            Tweet tweet = tweetOptional.get();
            if (tweet.getUserLikes().contains(user_id))
                tweet.getUserLikes().remove(user_id);
            else
                tweet.getUserLikes().add(user_id);
            return tweetRepository.save(tweet);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tweet not found");
    }

    public List<Tweet> getTweetsLikedByUser(Long user_id) {
        return tweetRepository.findByUserLikesContains(user_id);
    }

    public Tweet addComment(Long tweet_id, Tweet tweet) {
        Optional<Tweet> oParentTweet = tweetRepository.findById(tweet_id);
        if (oParentTweet.isPresent()) {
            Tweet parentTweet = oParentTweet.get();
            Tweet comment = createTweet(tweet);
            comment.setParentTweet(parentTweet);
            return tweetRepository.save(comment);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tweet not found");
    }

    public List<Tweet> getTweetComments(Long tweet_id) {
        Optional<Tweet> tweetOptional = tweetRepository.findById(tweet_id);
        if (tweetOptional.isPresent())
            return tweetRepository.findByParentTweet(tweetOptional.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tweet not found");
    }

    public void deleteTweet(Long tweet_id) {
        Optional<Tweet> tweetOptional = tweetRepository.findById(tweet_id);
        if (tweetOptional.isPresent()) tweetRepository.deleteById(tweet_id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tweet not found");
    }
}

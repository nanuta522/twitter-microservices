package com.finalProject.twittercatalogservice.service.impl;

import com.finalProject.twittercatalogservice.client.AccountDataService;
import com.finalProject.twittercatalogservice.client.TweetDataService;
import com.finalProject.twittercatalogservice.controller.dto.AdminAreaDTO;
import com.finalProject.twittercatalogservice.model.Admin;
import com.finalProject.twittercatalogservice.model.Tweet;
import com.finalProject.twittercatalogservice.model.User;
import com.finalProject.twittercatalogservice.service.interfaces.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService implements ICatalogService {
    @Autowired
    AccountDataService accountDataService;

    @Autowired
    TweetDataService tweetDataService;

    private void populateUser(Tweet tweet) {
        Long user_id = tweet.getUserId();
        try {
            User user = accountDataService.getUserById(user_id);
            tweet.setUser(user);
            tweet.setNumComments(getTweetComments(tweet.getTweet_id()).size());
        } catch (Exception e) {
            throw new IllegalArgumentException("User not found");
        }
    }

    public Tweet createTweet(Tweet tweet) {
        try {
            getUserById(tweet.getUserId());
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return tweetDataService.createTweet(tweet);
    }

    public List<Tweet> getAllTweets() {
        List<Tweet> tweetList = tweetDataService.getAllTweets();
        for (Tweet tweet : tweetList) {
            populateUser(tweet);
        }
        return tweetList;
    }

    public Tweet getTweetById(Long tweet_id) {
        Tweet tweet = tweetDataService.getTweetById(tweet_id);
        populateUser(tweet);
        return tweet;
    }

    public List<Tweet> getTweetsByUser(Long user_id) {
        List<Tweet> tweetList = tweetDataService.getTweetsByUser(user_id);
        for (Tweet tweet : tweetList) {
            populateUser(tweet);
        }
        return tweetList;
    }

    public Tweet likeTweet(Long user_id, Long tweet_id) {
        try {
            getUserById(user_id);
        } catch (Exception e) {
            throw new IllegalArgumentException("User not found");
        }
        return tweetDataService.likeTweet(user_id, tweet_id);
    }

    public List<Tweet> getTweetsLikedByUser(Long user_id) {
        List<Tweet> tweetList = tweetDataService.getTweetsLikedByUser(user_id);
        for (Tweet tweet : tweetList) {
            populateUser(tweet);
        }
        return tweetList;
    }

    public Tweet addComment(Long tweet_id, Tweet tweet) {
        try {
            getTweetById(tweet_id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tweet not found");
        }
        return tweetDataService.addComment(tweet_id, tweet);
    }

    public List<Tweet> getTweetComments(Long parent_tweet_id) {
        List<Tweet> commentList = tweetDataService.getTweetComments(parent_tweet_id);
        for (Tweet tweet : commentList) {
            populateUser(tweet);
        }
        return commentList;
    }

    public void deleteTweet(Long tweet_id) {
        try {
            getTweetById(tweet_id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tweet not found");
        }
        tweetDataService.deleteTweet(tweet_id);
    }

    public Admin createAdmin(Admin admin) {
        return accountDataService.createAdmin(admin);
    }

    public List<Admin> getAllAdmins() {
        return accountDataService.getAllAdmins();
    }

    public Admin getAdminById(Long admin_id) {
        return accountDataService.getAdminById(admin_id);
    }

    public Admin updateAdminInfo(Admin admin, Long admin_id) {
        return accountDataService.updateAdminInfo(admin, admin_id);
    }

    public Admin updateAdminArea(AdminAreaDTO adminAreaDTO, Long admin_id) {
        return accountDataService.updateAdminArea(adminAreaDTO, admin_id);
    }

    public void deleteAdmin(Long admin_id) {
        accountDataService.deleteAdmin(admin_id);
    }

    public User createUser(User user) {
        return accountDataService.createUser(user);
    }

    public List<User> getAllUsers() {
        return accountDataService.getAllUsers();
    }

    public User getUserById(Long user_id) {
        return accountDataService.getUserById(user_id);
    }

    public User updateUserInfo(Long user_id, User user) {
        return accountDataService.updateUserInfo(user_id, user);
    }

    public void deleteUser(Long user_id) {
        accountDataService.deleteUser(user_id);
    }
}

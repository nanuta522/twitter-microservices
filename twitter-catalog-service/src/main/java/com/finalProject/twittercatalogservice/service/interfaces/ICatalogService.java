package com.finalProject.twittercatalogservice.service.interfaces;


import com.finalProject.twittercatalogservice.controller.dto.AdminAreaDTO;
import com.finalProject.twittercatalogservice.model.Admin;
import com.finalProject.twittercatalogservice.model.Tweet;
import com.finalProject.twittercatalogservice.model.User;

import java.util.List;

public interface ICatalogService {
    public Tweet createTweet(Tweet tweet);
    public List<Tweet> getAllTweets();
    public Tweet getTweetById(Long tweet_id);
    public List<Tweet> getTweetsByUser(Long user_id);
    public Tweet likeTweet(Long user_id, Long tweet_id);
    public List<Tweet> getTweetsLikedByUser(Long user_id);
    public Tweet addComment(Long tweet_id, Tweet tweet);
    public List<Tweet> getTweetComments(Long parent_tweet_id);
    public void deleteTweet(Long tweet_id);
    public Admin createAdmin(Admin admin);
    public List<Admin> getAllAdmins();
    public Admin getAdminById(Long admin_id);
    public Admin updateAdminInfo(Admin admin,Long admin_id);
    public Admin updateAdminArea(AdminAreaDTO adminAreaDTO, Long admin_id);
    public void deleteAdmin(Long admin_id);
    public User createUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Long user_id);
    public User updateUserInfo(Long user_id, User user);
    public void deleteUser(Long user_id);
}

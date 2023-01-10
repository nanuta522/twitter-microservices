package com.finalProject.twittercatalogservice.controller;

import com.finalProject.twittercatalogservice.controller.dto.AdminAreaDTO;
import com.finalProject.twittercatalogservice.model.Admin;
import com.finalProject.twittercatalogservice.model.Tweet;
import com.finalProject.twittercatalogservice.model.User;
import com.finalProject.twittercatalogservice.service.interfaces.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;

    @PostMapping("/tweet")
    @ResponseStatus(HttpStatus.OK)
    public Tweet createTweet(@RequestBody Tweet tweet) {
        return catalogService.createTweet(tweet);
    }

    @GetMapping("/tweet/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getAllTweets() {
        return catalogService.getAllTweets();
    }

    @GetMapping("/tweet/{tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public Tweet getTweetById(@PathVariable Long tweet_id) {
        return catalogService.getTweetById(tweet_id);
    }

    @GetMapping("/tweet/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getTweetsByUser(@PathVariable Long user_id) {
        return catalogService.getTweetsByUser(user_id);
    }

    @PutMapping("/tweet/add-like/{user_id}/{tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public Tweet likeTweet(@PathVariable Long user_id, @PathVariable Long tweet_id) {
        return catalogService.likeTweet(user_id, tweet_id);
    }

    @GetMapping("/tweet/likes/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getTweetsLikedByUser(@PathVariable Long user_id) {
        return catalogService.getTweetsLikedByUser(user_id);
    }

    @PutMapping("/tweet/add-comment/{tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public Tweet addComment(@PathVariable Long tweet_id, @RequestBody Tweet tweet) {
        return catalogService.addComment(tweet_id, tweet);
    }

    @GetMapping("/tweet/comments/{parent_tweet_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getTweetComments(@PathVariable Long parent_tweet_id) {
        return catalogService.getTweetComments(parent_tweet_id);
    }

    @DeleteMapping("/tweet/{tweet_id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Tweet successfully deleted")
    public void deleteTweet(@PathVariable Long tweet_id) {
        catalogService.deleteTweet(tweet_id);
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public Admin createAdmin(@RequestBody Admin admin) {
       return catalogService.createAdmin(admin);
    }

    @GetMapping("/admin/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmins() {
        return catalogService.getAllAdmins();
    }

    @GetMapping("/admin/{admin_id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin getAdminById(@PathVariable Long admin_id) {
        return catalogService.getAdminById(admin_id);
    }

    @PutMapping("/admin/{admin_id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin updateAdminInfo(@RequestBody Admin admin, @PathVariable Long admin_id) {
        return catalogService.updateAdminInfo(admin, admin_id);
    }

    @PatchMapping("/admin/{admin_id}/area")
    @ResponseStatus(HttpStatus.OK)
    public Admin updateAdminArea(@RequestBody AdminAreaDTO adminAreaDTO, @PathVariable Long admin_id) {
        return catalogService.updateAdminArea(adminAreaDTO, admin_id);
    }

    @DeleteMapping("/admin/{admin_id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Admin successfully deleted")
    public void deleteAdmin(@PathVariable Long admin_id) {
        catalogService.deleteAdmin(admin_id);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@RequestBody User user) {
        return catalogService.createUser(user);
    }

    @GetMapping("/user/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return catalogService.getAllUsers();
    }

    @GetMapping("/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Long user_id) {
        return catalogService.getUserById(user_id);
    }

    @PutMapping("/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUserInfo(@PathVariable Long user_id, @RequestBody User user) {
        return catalogService.updateUserInfo(user_id, user);
    }

    @DeleteMapping("/user/{user_id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "User successfully deleted")
    public void deleteUser(@PathVariable Long user_id) {
        catalogService.deleteUser(user_id);
    }
}

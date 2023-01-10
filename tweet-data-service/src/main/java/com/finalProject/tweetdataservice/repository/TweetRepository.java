package com.finalProject.tweetdataservice.repository;

import com.finalProject.tweetdataservice.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findAllByUserIdEquals(Long userId);
    List<Tweet> findByUserLikesContains(Long userId);
    List<Tweet> findByParentTweet(Tweet parent);

    //List<Tweet> findAllByParentTweetIdEquals(Long parent);
}

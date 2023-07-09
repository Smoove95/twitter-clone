package com.twitterclone.socialmedia.service;

import com.twitterclone.socialmedia.model.Tweet;
import com.twitterclone.socialmedia.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;
    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    public Optional<Tweet> getTweetById(String id) {
        return tweetRepository.findById(id);
    }

    public Tweet saveTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public void deleteTweet(String id) {
        tweetRepository.deleteById(id);
    }
}

package com.twitterclone.socialmedia.controller;

import com.twitterclone.socialmedia.model.Tweet;
import com.twitterclone.socialmedia.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
@CrossOrigin(origins = "http://localhost:3000")
public class TweetController {

    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public ResponseEntity<List<Tweet>> getAllTweets() {
        return ResponseEntity.ok(tweetService.getAllTweets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable String id) {
        return tweetService.getTweetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tweet> createTweet(@RequestBody Tweet tweet) {
        return ResponseEntity.ok(tweetService.saveTweet(tweet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tweet> updateTweet(@PathVariable String id, @RequestBody Tweet tweet) {
        return tweetService.getTweetById(id)
                .map(existingTweet -> {
                    // update fields of existingTweet using fields of tweet
                    return ResponseEntity.ok(tweetService.saveTweet(existingTweet));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTweet(@PathVariable String id) {
        if (tweetService.getTweetById(id).isPresent()) {
            tweetService.deleteTweet(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.twitterclone.socialmedia.repository;

import com.twitterclone.socialmedia.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TweetRepository extends MongoRepository<Tweet, String> {

}

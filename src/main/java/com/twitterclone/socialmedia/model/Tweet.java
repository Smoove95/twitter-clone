package com.twitterclone.socialmedia.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "tweets")
public class Tweet {
    @Id
    private String id;

    @Field("userId")
    private String userId;

    @Field("content")
    private String content;

    @Field("posted")
    private LocalDateTime posted;

    @Field("likes")
    private List<String> likes;

    @Field("retweets")
    private List<String> retweets;

    @Field("replies")
    private List<Reply> replies;

    public static class Reply {
        @Field("userId")
        private String userId;

        @Field("content")
        private String content;

        @Field("posted")
        private LocalDateTime posted;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public LocalDateTime getPosted() {
            return posted;
        }

        public void setPosted(LocalDateTime posted) {
            this.posted = posted;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getRetweets() {
        return retweets;
    }

    public void setRetweets(List<String> retweets) {
        this.retweets = retweets;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}

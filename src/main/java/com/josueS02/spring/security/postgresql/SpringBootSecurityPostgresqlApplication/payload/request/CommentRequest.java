// src/main/java/com/josueS02/spring/security/postgresql/SpringBootSecurityPostgresqlApplication/payload/request/CommentRequest.java
package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.payload.request;

public class CommentRequest {
    private Long tweetId;
    private String content;
    // getters / setters
    public Long getTweetId() { return tweetId; }
    public void setTweetId(Long tweetId) { this.tweetId = tweetId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}

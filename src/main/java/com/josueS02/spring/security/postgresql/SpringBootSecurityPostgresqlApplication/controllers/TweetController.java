package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.controllers;

import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.TweetModel;
import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.User;
import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository.TweetRepository;
import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository.UserRepository;
import jakarta.validation.Valid;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tweets")

public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/all")
    public Page<TweetModel> getTweet(Pageable pageable) {
        return tweetRepository.findAll(pageable);
    }

    @PostMapping("/create")
public TweetModel createTweet(@Valid @RequestBody TweetModel tweet) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userId = authentication.getName();
    System.out.println("userid : " + userId);

    User user = getValidUser(userId);
    System.out.println("user");
    System.out.println(user);

    TweetModel myTweet = new TweetModel(tweet.getTweet());
    myTweet.setPostedBy(user);

    // Guarda y usa el objeto devuelto por save()
    TweetModel savedTweet = tweetRepository.save(myTweet);

    return savedTweet; // <--- devuelve este!
}


    @Autowired
    private UserRepository userRepository;

    private User getValidUser(String userId) {
        Optional<User> userOpt = userRepository.findByUsername(userId);
        if (!userOpt.isPresent()) {
            throw new RuntimeException("User not found");
        }
        return userOpt.get();
    }

}

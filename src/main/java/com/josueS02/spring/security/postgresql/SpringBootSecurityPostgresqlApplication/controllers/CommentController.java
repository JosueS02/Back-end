// src/main/java/com/josueS02/spring/security/postgresql/SpringBootSecurityPostgresqlApplication/controllers/CommentController.java
package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.controllers;

import java.util.List;

import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.*;
import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.payload.request.CommentRequest;
import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired private CommentRepository commentRepo;
    @Autowired private TweetRepository tweetRepo;
    @Autowired private UserRepository userRepo;

    /** 1️⃣ Listar comentarios de un tweet */
    @GetMapping("/tweet/{tweetId}")
    public List<CommentModel> getByTweet(@PathVariable Long tweetId) {
        return commentRepo.findByTweetId(tweetId);
    }

    /** 2️⃣ Crear un comentario (requiere JWT válido) */
    @PostMapping("/create")
    public CommentModel create(@RequestBody CommentRequest req) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName())
                            .orElseThrow(() -> new RuntimeException("User not found"));

        TweetModel tweet = tweetRepo.findById(req.getTweetId())
                                    .orElseThrow(() -> new RuntimeException("Tweet not found"));

        CommentModel c = new CommentModel();
        c.setContent(req.getContent());
        c.setTweet(tweet);
        c.setUser(user);
        return commentRepo.save(c);
    }

    /** 3️⃣ Borrar un comentario (sólo si fue tuyo) */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName())
                            .orElseThrow(() -> new RuntimeException("User not found"));
        commentRepo.deleteByIdAndUserId(id, user.getId());
        return ResponseEntity.noContent().build();
    }
}

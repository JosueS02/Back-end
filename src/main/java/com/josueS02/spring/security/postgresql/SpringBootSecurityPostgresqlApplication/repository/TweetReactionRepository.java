package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository;

import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.TweetReaction;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josue
 */
@Repository
public interface TweetReactionRepository extends JpaRepository<TweetReaction, Long> {
    Optional<TweetReaction> findByTweetIdAndUserId(Long tweetId, Long userId);
    void deleteByTweetIdAndUserId(Long tweetId, Long userId);
}

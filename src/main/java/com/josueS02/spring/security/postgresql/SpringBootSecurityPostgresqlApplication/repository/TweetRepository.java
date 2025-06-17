package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.TweetModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long> {

}

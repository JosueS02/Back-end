package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository;

import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josue
 */
@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}

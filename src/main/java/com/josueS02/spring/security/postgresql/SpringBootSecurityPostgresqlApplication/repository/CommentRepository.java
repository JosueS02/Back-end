// src/main/java/com/josueS02/spring/security/postgresql/SpringBootSecurityPostgresqlApplication/repository/CommentRepository.java
package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models.CommentModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    // Trae todos los comentarios de un tweet
    List<CommentModel> findByTweetId(Long tweetId);

    // Borra un comentario sólo si es del usuario autenticado
    @Modifying
    @Transactional
    void deleteByIdAndUserId(Long commentId, Long userId);
}

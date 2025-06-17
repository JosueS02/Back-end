package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models;

import jakarta.persistence.*;

/**
 *
 * @author josue
 */
@Entity
@Table(name = "reactions")
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EReaction description;

    public Reaction() {
    }

    public Reaction(EReaction description) {
        this.description = description;
    }

    public EReaction getDescription() {
        return description;
    }

    public void setDescription(EReaction description) {
        this.description = description;
    }
}

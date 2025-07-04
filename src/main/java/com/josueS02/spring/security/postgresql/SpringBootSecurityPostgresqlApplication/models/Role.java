package com.josueS02.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

  public Role() {

  }

  public Role(ERole name) {
    this.name = name;
  }

  // getters and setters

  public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public ERole getName() {
    return name;
}

public void setName(ERole name) {
    this.name = name;
}

}

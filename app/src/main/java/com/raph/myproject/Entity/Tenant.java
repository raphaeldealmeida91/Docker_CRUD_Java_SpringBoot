package com.raph.myproject.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tenant", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "key")
})
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String key;

    // Constructeurs
    public Tenant() {
    }

    public Tenant(String name, String key) {
        this.name = name;
        this.key = key;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

package com.example.projectVishwa.model;


import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Getters and Setters

    public enum Role {
        ADMIN, DATA_OWNER, DATA_USER
    }

    public enum Status {
        ACTIVE, INACTIVE
    }
}


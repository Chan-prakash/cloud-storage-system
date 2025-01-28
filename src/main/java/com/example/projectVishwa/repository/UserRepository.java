package com.example.projectVishwa.repository;

import com.example.projectVishwa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}


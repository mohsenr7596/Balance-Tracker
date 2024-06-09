package com.example.balancetracker.repository.user;

import com.example.balancetracker.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
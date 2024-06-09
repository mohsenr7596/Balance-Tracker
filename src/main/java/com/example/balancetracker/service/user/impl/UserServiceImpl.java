package com.example.balancetracker.service.user.impl;

import com.example.balancetracker.repository.user.UserRepository;
import com.example.balancetracker.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public int getBalance(long userId) {
        final var user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getBalance();
    }
}

package com.example.balancetracker.service.user;

import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    int getBalance(long userId);
}

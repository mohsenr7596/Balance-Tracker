package com.example.balancetracker.service.transaction;

public interface TransactionService {
    long addMoney(long userId, int amount);

    Double getLast24HoursTotal();
}

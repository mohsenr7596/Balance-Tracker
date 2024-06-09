package com.example.balancetracker.repository.transaction;

import com.example.balancetracker.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(long userId);
}

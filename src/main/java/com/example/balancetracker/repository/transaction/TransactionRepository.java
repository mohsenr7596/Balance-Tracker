package com.example.balancetracker.repository.transaction;

import com.example.balancetracker.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(long userId);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.timestamp >= :startDate")
    Double findTotalAmountForLast24Hours(Date startDate);
}

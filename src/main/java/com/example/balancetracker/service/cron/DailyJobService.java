package com.example.balancetracker.service.cron;

import com.example.balancetracker.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DailyJobService {
    private final TransactionService transactionService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void reportDailyTransactions() {
        log.info("Report daily transactions");
        final var totalAmount = transactionService.getLast24HoursTotal();
        log.info("Total amount of transactions today: {}", totalAmount);
    }
}

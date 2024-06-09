package com.example.balancetracker.controller.wallet;

import com.example.balancetracker.dto.TransactionResponseDto;
import com.example.balancetracker.dto.UserBalanceResponseDto;
import com.example.balancetracker.service.transaction.TransactionService;
import com.example.balancetracker.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {
    private UserService userService;
    private TransactionService transactionService;

    @GetMapping("/balance")
    public ResponseEntity<UserBalanceResponseDto> getBalance(
            @RequestParam long userId
    ) {
        final var balance = userService.getBalance(userId);
        final var response = new UserBalanceResponseDto(balance);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-money")
    public ResponseEntity<TransactionResponseDto> addMoney(
            @RequestParam Long userId,
            @RequestParam int amount
    ) {
        final var referenceId = transactionService.addMoney(userId, amount);
        final var response = new TransactionResponseDto(referenceId);
        return ResponseEntity.ok(response);
    }
}

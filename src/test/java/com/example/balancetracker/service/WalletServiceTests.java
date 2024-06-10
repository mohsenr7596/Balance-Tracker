package com.example.balancetracker.service;

import com.example.balancetracker.domain.transaction.Transaction;
import com.example.balancetracker.domain.user.User;
import com.example.balancetracker.repository.transaction.TransactionRepository;
import com.example.balancetracker.repository.user.UserRepository;
import com.example.balancetracker.service.transaction.impl.TransactionServiceImpl;
import com.example.balancetracker.service.user.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class WalletServiceTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    void setUp() {
        // Mock initialization is handled by @ExtendWith(MockitoExtension.class)
    }

    @Test
    void testGetBalance() {
        User user = new User();
        user.setId(1L);
        user.setBalance(5000);

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        int balance = userService.getBalance(1);

        assertEquals(5000, balance);
    }

    @Test
    void testAddMoney() {
        User user = new User();
        user.setId(1L);
        user.setBalance(5000);

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(
                new User(1L, "ali", 7000, Set.of())
        ));
        Mockito.when(transactionRepository.save(ArgumentMatchers.any(Transaction.class))).thenAnswer(invocation -> {
            Transaction transaction = invocation.getArgument(0);
            transaction.setId(123456789L); // Assuming setId() method exists and sets the ID
            return transaction;
        });

        long referenceId = transactionService.addMoney(1, 2000);

        assertNotNull(referenceId);
        Mockito.verify(transactionRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
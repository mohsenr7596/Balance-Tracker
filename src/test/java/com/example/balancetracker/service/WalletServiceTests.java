package com.example.balancetracker.service;

import com.example.balancetracker.domain.transaction.Transaction;
import com.example.balancetracker.domain.user.User;
import com.example.balancetracker.repository.transaction.TransactionRepository;
import com.example.balancetracker.repository.user.UserRepository;
import com.example.balancetracker.service.transaction.TransactionService;
import com.example.balancetracker.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WalletServiceTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBalance() {
        final var user = new User();
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

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        long referenceId = transactionService.addMoney(1, 2000);

        assertNotNull(referenceId);
        assertEquals(7000, user.getBalance());
        Mockito.verify(transactionRepository, Mockito.times(1)).save(ArgumentMatchers.any(Transaction.class));
    }
}

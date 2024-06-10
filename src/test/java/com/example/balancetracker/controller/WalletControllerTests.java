package com.example.balancetracker.controller;

import com.example.balancetracker.service.transaction.TransactionService;
import com.example.balancetracker.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WalletControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        // Mock UserService to return a balance for a specific user
        when(userService.getBalance(1L)).thenReturn(4000);

        // Mock TransactionService to return a reference ID when money is added
        when(transactionService.addMoney(1L, 2000)).thenReturn(12312312312L);
    }

    @Test
    void testGetBalance() throws Exception {
        mockMvc.perform(get("/wallet/balance")
                        .param("user_id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"balance\":4000}"));
    }

    @Test
    void testAddMoney() throws Exception {
        mockMvc.perform(
                        post("/wallet/add-money")
                                .param("user_id", "1")
                                .param("amount", "2000")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{\"reference_id\":12312312312}"));
    }
}

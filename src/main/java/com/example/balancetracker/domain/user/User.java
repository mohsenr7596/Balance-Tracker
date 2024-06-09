package com.example.balancetracker.domain.user;

import com.example.balancetracker.domain.transaction.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "btr_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int balance;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Transaction> transactions = new LinkedHashSet<>();
}
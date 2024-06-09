package com.example.balancetracker.domain.transaction;

import com.example.balancetracker.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "btr_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_user_id", nullable = false)
    private User user;

    private int amount;

    private LocalDateTime timestamp;
}

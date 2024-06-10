package com.example.balancetracker.repository.user;

import com.example.balancetracker.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query("update User u set u.balance = (u.balance + :changeBalance) where u.id = :id")
    void updateBalanceById(@Param("id") long id, @Param("changeBalance") @NonNull int changeBalance);
}
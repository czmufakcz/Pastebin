package com.pastebin.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pastebin.account.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

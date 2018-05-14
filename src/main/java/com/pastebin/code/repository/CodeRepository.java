package com.pastebin.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pastebin.account.model.User;
import com.pastebin.code.model.Code;

public interface CodeRepository extends JpaRepository<Code, Integer> {
    List<Code> findByUser(User user);
}

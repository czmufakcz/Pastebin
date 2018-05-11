package com.pastebin.account.service;

import com.pastebin.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

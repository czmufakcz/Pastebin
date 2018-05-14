package com.pastebin.code.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pastebin.account.model.User;
import com.pastebin.code.model.Code;

public interface CodeService {
    
    List<Code> getCodes(User user);

    void save(Code code);
}

package com.pastebin.code.service;

import java.util.List;
import java.util.Optional;

import com.pastebin.account.model.User;
import com.pastebin.code.model.Code;

public interface CodeService {
    
    List<Code> getCodes(User user);

    void save(Code code);
    
    void delete(Integer id);
    
    Optional<Code> findById(Integer id);

}

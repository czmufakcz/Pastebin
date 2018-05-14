package com.pastebin.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pastebin.account.model.User;
import com.pastebin.code.model.Code;
import com.pastebin.code.repository.CodeRepository;

import lombok.RequiredArgsConstructor;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeRepository codeRepository;
    
    
    @Override
    public List<Code> getCodes(User user) {
	return codeRepository.findByUser(user);
    }

    @Override
    public void save(Code code) {
	codeRepository.save(code);
    }

}

package com.pastebin.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pastebin.account.model.User;
import com.pastebin.code.model.Code;
import com.pastebin.code.repository.CodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;
    
    @Override
    public List<Code> getCodes(User user) {
	return codeRepository.findByUser(user);
    }

    @Override
    public void save(Code code) {
	codeRepository.save(code);
    }

    @Override
    public void delete(Integer id) {
	codeRepository.deleteById(id);
    }

    @Override
    public Optional<Code> findById(Integer id) {
	return codeRepository.findById(id);
    }

}

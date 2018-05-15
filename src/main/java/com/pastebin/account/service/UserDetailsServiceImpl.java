package com.pastebin.account.service;

import com.pastebin.account.model.Role;
import com.pastebin.account.model.User;
import com.pastebin.account.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.findByUsername(username);

	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	for (Role role : user.getRoles()) {
	    grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	}

	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
		grantedAuthorities);
    }
}

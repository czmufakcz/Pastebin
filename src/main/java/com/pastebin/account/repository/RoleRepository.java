package com.pastebin.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pastebin.account.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}

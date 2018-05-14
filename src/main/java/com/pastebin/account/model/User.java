package com.pastebin.account.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class User {
    private Integer id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Column(name = "username", length = 255, nullable = false)
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @Column(name = "password", length = 255, nullable = false)
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
	return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
	this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
	return roles;
    }

    public void setRoles(Set<Role> roles) {
	this.roles = roles;
    }

}

package com.pastebin.account.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    private Integer id;
    private String name;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Column(name = "name", length = 20, nullable = false)
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
	return users;
    }

    public void setUsers(Set<User> users) {
	this.users = users;
    }
}

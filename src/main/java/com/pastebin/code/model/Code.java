package com.pastebin.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pastebin.account.model.User;

@Entity
@Table(name = "code")
public class Code {
    private Integer id;
    private String code;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Lob
    @Column(name = "code", nullable = false)
    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    @ManyToOne
    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

}

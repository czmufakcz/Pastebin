package com.pastebin.code.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pastebin.account.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "code")
@Access(AccessType.FIELD)
@Getter
@Setter
@ToString
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Lob
    @Column(name = "code", nullable = false)
    private String code;
    @ManyToOne
    private User user;
}

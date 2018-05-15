package com.pastebin.code.model;

import java.io.Serializable;

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
import javax.persistence.UniqueConstraint;

import com.pastebin.account.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "code",uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })
@Access(AccessType.FIELD)
@Getter
@Setter
@ToString
public class Code implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Lob
    @Column(name = "code", nullable = false)
    private String code;
    @ManyToOne
    private User user;
}

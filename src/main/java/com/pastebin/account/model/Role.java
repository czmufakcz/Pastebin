package com.pastebin.account.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "role")
@Access(AccessType.FIELD)
@Getter
@Setter
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}

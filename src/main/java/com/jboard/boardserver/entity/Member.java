package com.jboard.boardserver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String contents;

    @Builder
    Member(String id, String password, String name, String email, String phone, String contents) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.contents = contents;
    }

    public Member() {

    }
}

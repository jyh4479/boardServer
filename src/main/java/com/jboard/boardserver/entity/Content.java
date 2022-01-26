package com.jboard.boardserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//JPA 매핑 참고
//https://lar542.github.io/JPA/2019-09-08-JPA2/
@Data
@Table(name = "content")
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String writer;

    @Column
    private String title;

    @Column
    private String detail;

    @Column
    private String date;


    @OneToMany(mappedBy = "content")
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<Comment>();

    @Column
    private String comment;

    @Builder
    public Content(String writer, String title, String detail, String date, String comment) {
        this.writer = writer;
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.comment = comment;
    }

    public Content() {

    }
}

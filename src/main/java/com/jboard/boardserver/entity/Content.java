package com.jboard.boardserver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

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

    @Column
    private String comment;

    @Builder
    Content(Long id, String writer, String title, String detail, String date, String comment) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.comment = comment;
    }

    public Content() {

    }
}

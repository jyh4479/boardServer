package com.jboard.boardserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

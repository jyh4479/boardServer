package com.jboard.boardserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column
//    @JoinColumn(name = "content_id")
//    private Long contentId;

    @Column
    private String writer;

    @Column
    private String detail;

    @Column
    private String date;


    //https://dalgoo.tistory.com/37 --> Comment가 등록 성공했을때 매칭되는 Content를 조회하는 곳에서 오류가 나옴
    //풀이를 위한 어노테이션과 원리 찾아보기
    @ManyToOne
    @JoinColumn(name = "CONTENT_ID")
    @JsonBackReference
    private Content content;

    @Builder
    public Comment(Content content, String writer, String detail, String date) {
        this.content = content;
        this.writer = writer;
        this.detail = detail;
        this.date = date;
    }

    public Comment() {

    }
}

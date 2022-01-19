package com.jboard.boardserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class SearchOption {
    private Long id;
    private String writer;
    private String title;
    private String detail;
    private String date;
    private String comment;

    @Builder
    public SearchOption(Long id, String writer, String title, String detail, String date, String comment) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.comment = comment;
    }
}

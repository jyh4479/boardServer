package com.jboard.boardserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class SearchOption {
    private Long id;
    private String writer;
    private String title;
    private String date;

    @Builder
    public SearchOption(Long id, String writer, String title, String date) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.date = date;
    }
}

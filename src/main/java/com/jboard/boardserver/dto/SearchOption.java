package com.jboard.boardserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class SearchOption {
    private Long id;
    private String title;
    private String writer;
    private String date;

    @Builder
    public SearchOption(Long id, String title, String writer, String date) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.date = date;
    }
}

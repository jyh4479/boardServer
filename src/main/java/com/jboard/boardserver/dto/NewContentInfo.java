package com.jboard.boardserver.dto;

import lombok.Data;

@Data
public class NewContentInfo {
    private String writer;
    private String title;
    private String detail;
    private String date;
}

package com.jboard.boardserver.dto;

import lombok.Data;

@Data
public class DeleteContentInfo {
    private String writer;
    private Long contentNumber;
}

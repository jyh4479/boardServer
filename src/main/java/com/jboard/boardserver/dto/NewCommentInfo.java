package com.jboard.boardserver.dto;

import lombok.Data;

@Data
public class NewCommentInfo {
    //래핑되어있는 데이터 타입은 못받네..? ex(Integer, Long) 왜지..?
    private long contentId;
    private String writer;
    private String detail;
    private String date;
}

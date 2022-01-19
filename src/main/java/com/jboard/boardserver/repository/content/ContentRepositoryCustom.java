package com.jboard.boardserver.repository.content;

import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContentRepositoryCustom {
    List<Content> findByOption(SearchOption searchOption);
}

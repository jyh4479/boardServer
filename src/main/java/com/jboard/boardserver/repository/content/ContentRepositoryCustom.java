package com.jboard.boardserver.repository.content;

import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentRepositoryCustom {
    List<Content> findByOption(Pageable paging, SearchOption searchOption);

    Integer findByOptionSize(SearchOption searchOption);
}

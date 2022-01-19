package com.jboard.boardserver.repository.content;

import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.entity.QContent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
public class ContentRepositoryImpl implements ContentCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<Content> findByOption(SearchOption searchOption) {
        return jpaQueryFactory.selectFrom(QContent.content)
                .where(QContent.content.writer.eq(searchOption.getWriter()))
                .fetch();
    }
}
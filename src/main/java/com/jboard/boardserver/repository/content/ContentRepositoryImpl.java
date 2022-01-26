package com.jboard.boardserver.repository.content;

import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.entity.QContent;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Log
@AllArgsConstructor
public class ContentRepositoryImpl implements ContentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private BooleanExpression eqId(Long id) {
        if (id == null) return null;
        else return QContent.content.id.eq(id);
    }

    private BooleanExpression containWriter(String writer) {
        if (writer == null) return null;
        else return QContent.content.writer.contains(writer);
    }

    private BooleanExpression containTitle(String title) {
        if (title == null) return null;
        else return QContent.content.title.contains(title);
    }

    private BooleanExpression eqDate(String date) {
        if (date == null) return null;
        else return QContent.content.date.eq(date);
    }

    public List<Content> findByOption(Pageable paging, SearchOption searchOption) {
        log.info("run ContentRepositoryImpl findByOption");
        List<Content> result = jpaQueryFactory.selectFrom(QContent.content)
                .where(eqId(searchOption.getId()),
                        containTitle(searchOption.getTitle()),
                        eqDate(searchOption.getDate()),
                        containWriter(searchOption.getWriter()))
                .offset(paging.getPageNumber() * paging.getPageSize())
                .limit(paging.getPageSize())
                .fetch();
        return result;
    }

    public Integer findByOptionSize(SearchOption searchOption) {
        List<Content> result = jpaQueryFactory.selectFrom(QContent.content)
                .where(eqId(searchOption.getId()),
                        containTitle(searchOption.getTitle()),
                        eqDate(searchOption.getDate()),
                        containWriter(searchOption.getWriter()))
                .fetch();
        return result.size();
    }
}
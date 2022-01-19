package com.jboard.boardserver.queryDslTest;

import com.jboard.boardserver.entity.Content;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.jboard.boardserver.entity.QContent.content;

@SpringBootTest
@Transactional
public class ContentQueryDslTest {

    @PersistenceContext
    private EntityManager em;

    JPAQueryFactory queryFactory;

    @Test
    void QueryTest() {

        queryFactory = new JPAQueryFactory(em);
        String name = "jyh4479";
        String name2 = null;

        List<Content> findContent = queryFactory
                .selectFrom(content)
                .where(name == null ? null : content.writer.eq(name))
                .fetch();

        System.out.println(findContent);
    }
}

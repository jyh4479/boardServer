package com.jboard.boardserver.queryDslTest;

import com.jboard.boardserver.config.TestConfig;
import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.repository.content.ContentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Import(TestConfig.class)
@SpringBootTest
public class RepositoryExtendsTest {

    @Autowired
    private ContentRepository contentRepository;

    @Test
    public void getDataTest() {
        SearchOption searchOption = new SearchOption(null, "jyh4479", null, null);
        Pageable paging = PageRequest.of(0, 5);

        List<Content> contentList = contentRepository.findByOption(paging, searchOption);

        System.out.println(contentList);
    }
}

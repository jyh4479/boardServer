package com.jboard.boardserver.queryDslTest;

import com.jboard.boardserver.config.TestConfig;
import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.repository.content.ContentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(TestConfig.class)
@SpringBootTest
public class RepositoryExtendsTest {

    @Autowired
    private ContentRepository contentRepository;

    @Test
    public void getDataTest() {
        SearchOption searchOption = new SearchOption(null, "jyh4479", null, null, null, null);

        List<Content> contentList = contentRepository.findByOption(searchOption);

        System.out.println(contentList);
    }
}

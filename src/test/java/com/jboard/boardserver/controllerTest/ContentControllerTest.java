package com.jboard.boardserver.controllerTest;

import com.jboard.boardserver.repository.content.ContentRepository;
import com.jboard.boardserver.service.ContentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
//@WebMvcTest(ContentsController.class)
@AutoConfigureMockMvc
public class ContentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ContentRepository contentRepository;

//    @MockBean
//    ContentService contentService;
    @Autowired
    ContentService contentService;

    @Test
    @DisplayName("Get Content Count Test")
    void getContentCount() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contentsize");

//        when(contentService.getContentSize()).thenReturn(contentRepository.findAll().size());

        this.mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }
}

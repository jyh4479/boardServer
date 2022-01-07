package com.jboard.boardserver.controllerTest;

import com.jboard.boardserver.controller.MemberController;
import com.jboard.boardserver.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//https://frozenpond.tistory.com/82 참고
@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MemberService memberService;

    @Test
    @DisplayName("Test env setting")
    void getMemberInfoTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test")
                .param("id", String.valueOf(1))
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(requestBuilder).andExpect(status().isOk());

        verify(memberService).logService2();

    }
}

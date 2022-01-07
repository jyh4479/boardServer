package com.jboard.boardserver.controller;

import com.jboard.boardserver.entity.Member;
import com.jboard.boardserver.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;
//    @RequestMapping("/test")
//    public Member getMemberInfo(@RequestBody String id) {
//        log.info("Request from " + id);
//        return null;
//    }

    @RequestMapping("/test")
    public Member getMemberInfo(@RequestParam String id) {
        log.info("Request from " + id);
        memberService.logService();
        return null;
    }
}

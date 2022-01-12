package com.jboard.boardserver.controller;

import com.jboard.boardserver.dto.LoginInfo;
import com.jboard.boardserver.entity.Member;
import com.jboard.boardserver.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    public Member getMemberInfo(@RequestParam String id) {
        log.info("Request from " + id);
        memberService.logService();
        return null;
    }

    @PostMapping("/login")
    public boolean loginTestLogic(@RequestBody LoginInfo loginInfo) {
        try {
            memberService.loginTestLogic(loginInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/member")
    public ResponseEntity<?> addMember(@RequestBody Member member) {
        log.info("run addMember in MemberController");
        try {
            memberService.addMember(member);
            return new ResponseEntity<>(null, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

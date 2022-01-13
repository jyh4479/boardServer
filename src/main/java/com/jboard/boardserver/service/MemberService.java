package com.jboard.boardserver.service;

import com.jboard.boardserver.dto.LoginInfo;
import com.jboard.boardserver.entity.Member;
import com.jboard.boardserver.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log
@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addMember(Member member) {
        log.info("run addMember in MemberService");
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public boolean loginTestLogic(LoginInfo loginInfo) throws Exception {
        try {
            log.info("login Service");
            log.info(String.valueOf(loginInfo));
            Member member = memberRepository.getById(loginInfo.getId());
            if (member.getPassword().equals(loginInfo.getPassword()))
                return true;
            return false;
        } catch (Exception e) {
            throw new Exception();
        }

    }

    public void logService() {
        log.info("log service run");
    }

    public void logService2() {
        log.info("log service run2");
    }
}

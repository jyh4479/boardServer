package com.jboard.boardserver.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class MemberService {

    public void logService() {
        log.info("log service run");
    }

    public void logService2() {
        log.info("log service run2");
    }
}

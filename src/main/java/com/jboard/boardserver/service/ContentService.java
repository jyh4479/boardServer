package com.jboard.boardserver.service;

import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.repository.ContentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    @Transactional(readOnly = true)
    public List<?> getContentList() throws Exception {
        log.info("run getContentList in ContentService");
        try {
            return contentRepository.findAll();
        } catch (Exception e) {
            log.warning("error getContentList in ContentService");
            throw new Exception();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void addContent(Content content) {
        log.info("run addContent in ContentService");
        contentRepository.save(content);
    }
}

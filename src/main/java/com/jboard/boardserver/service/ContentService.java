package com.jboard.boardserver.service;

import com.jboard.boardserver.dto.DeleteContentInfo;
import com.jboard.boardserver.dto.NewContentInfo;
import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.repository.content.ContentRepository;
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

    @Transactional(readOnly = true)
    public List<?> getSearchContentList(SearchOption searchOption) throws Exception {
        log.info("run getSearchContentList in ContentService");
        try {
            return contentRepository.findByOption(searchOption);
        } catch (Exception e) {
            log.warning("error getSearchContentList in ContentService");
            throw new Exception();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void addContent(NewContentInfo newContentInfo) {
        log.info("run addContent in ContentService");
        Content newContent = new Content(
                newContentInfo.getWriter(),
                newContentInfo.getTitle(),
                newContentInfo.getDetail(),
                newContentInfo.getDate(),
                null
        );
        contentRepository.save(newContent);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteContent(DeleteContentInfo deleteContentInfo) {
        log.info("run deleteContent in ContentService");
        log.info(String.valueOf(deleteContentInfo));
        Content content = contentRepository.getById(deleteContentInfo.getContentNumber());
        if (content.getWriter().equals(deleteContentInfo.getWriter())) {
            contentRepository.delete(content);
            return true;
        } else {
            return false;
        }
    }
}

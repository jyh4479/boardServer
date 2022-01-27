package com.jboard.boardserver.service;

import com.jboard.boardserver.dto.DeleteContentInfo;
import com.jboard.boardserver.dto.NewContentInfo;
import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.repository.content.ContentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log
@Service
@AllArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    @Transactional(readOnly = true)
    public Optional<Content> getContent(Long id) throws Exception {
        log.info("run getContent in ContentService");
        try {
            return contentRepository.findById(id);
        } catch (Exception e) {
            log.warning("error getContent in ContentService");
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    public List<?> getContentList(Pageable paging, SearchOption searchOption) throws Exception {
        log.info("run getContentList in ContentService");
        try {
            return contentRepository.findByOption(paging, searchOption);
        } catch (Exception e) {
            log.warning("error getContentList in ContentService");
            throw new Exception();
        }
    }

    @Transactional(readOnly = true)
    public Object getContentSize(SearchOption searchOption) throws Exception {
        log.info("run getContentSize in ContentService");
        try {
            return contentRepository.findByOptionSize(searchOption);
        } catch (Exception e) {
            log.warning("error getContentSize in ContentService");
            return new Exception();
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
        }
        return false;
    }
}

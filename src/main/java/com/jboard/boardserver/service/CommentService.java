package com.jboard.boardserver.service;

import com.jboard.boardserver.dto.DeleteContentInfo;
import com.jboard.boardserver.dto.NewCommentInfo;
import com.jboard.boardserver.entity.Comment;
import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.repository.CommentRepository.CommentRepository;
import com.jboard.boardserver.repository.content.ContentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ContentRepository contentRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addComment(NewCommentInfo newCommentInfo) {
        log.info("run addComment in ContentService");

        Content selectContent = contentRepository.getById(newCommentInfo.getContentId());

        Comment newComment = new Comment(
                selectContent,
                newCommentInfo.getWriter(),
                newCommentInfo.getDetail(),
                newCommentInfo.getDate()
        );

        commentRepository.save(newComment);
    }

    @Transactional(readOnly = true)
    public List<Comment> getCommentList(Long id) throws Exception {
        log.info("run getCommentList in ContentService");
        try {
            return contentRepository.findById(id).get().getCommentList();
        } catch (Exception e) {
            log.warning("error getCommentList in CommentService");
            throw new Exception();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCommentList(DeleteContentInfo deleteContentInfo) throws Exception {
        log.info("run deleteCommentList in CommentService");
        log.info(String.valueOf(deleteContentInfo));
        Comment comment = commentRepository.getById(deleteContentInfo.getContentNumber());
        if (comment.getWriter().equals(deleteContentInfo.getWriter())) {
            commentRepository.delete(comment);
            return true;
        }
        return false;
    }
}

package com.jboard.boardserver.controller;

import com.jboard.boardserver.dto.DeleteContentInfo;
import com.jboard.boardserver.dto.NewCommentInfo;
import com.jboard.boardserver.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<?> addComment(@RequestBody NewCommentInfo newCommentInfo) {
        log.info("run addComment in CommentController");
        try {
            commentService.addComment(newCommentInfo);
            return new ResponseEntity<>(true, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/commentList")
    public ResponseEntity<?> getCommentList(@RequestParam Long id) {
        log.info("run getCommentList in CommentController");
        try {
            return new ResponseEntity<>(commentService.getCommentList(id), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/commentDelete")
    public ResponseEntity<?> deleteComment(@RequestBody DeleteContentInfo deleteContentInfo) {
        log.info("run deleteComment in CommentController");
        try {
            if (commentService.deleteCommentList(deleteContentInfo))
                return new ResponseEntity<>(true, null, HttpStatus.OK);
            return new ResponseEntity<>(false, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

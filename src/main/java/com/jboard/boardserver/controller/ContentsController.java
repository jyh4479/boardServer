package com.jboard.boardserver.controller;

import com.jboard.boardserver.entity.Content;
import com.jboard.boardserver.service.ContentService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@AllArgsConstructor
public class ContentsController {

    private final ContentService contentService;

    @GetMapping("/contentlist")
    public ResponseEntity<?> getContentList() {
        log.info("run getContentList in ContentsController");
        try {
            return new ResponseEntity<>(contentService.getContentList(), null, HttpStatus.OK);
        } catch (Exception e) {
            log.warning("error getContentList in ContentsController");
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/content")
    public ResponseEntity<?> addContent(@RequestBody Content content) {
        log.info("run addContent in ContentsController");
        try {
            contentService.addContent(content);
            return new ResponseEntity<>(null, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

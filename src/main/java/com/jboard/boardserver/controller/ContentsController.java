package com.jboard.boardserver.controller;

import com.jboard.boardserver.dto.DeleteContentInfo;
import com.jboard.boardserver.dto.NewContentInfo;
import com.jboard.boardserver.dto.SearchOption;
import com.jboard.boardserver.service.ContentService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/searchcontentlist")
    public ResponseEntity<?> getSearchContentList(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "writer", required = false) String writer, @RequestParam(value = "date", required = false) String date) {
        log.info("run getContentList in getSearchContentList");

        log.info("check date : " + id);
        log.info("check date : " + title);
        log.info("check date : " + writer);
        log.info("check date : " + date);

        SearchOption searchOption = new SearchOption(id, title, writer, date);

        try {
            return new ResponseEntity<>(contentService.getSearchContentList(searchOption), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/content")
    public ResponseEntity<?> addContent(@RequestBody NewContentInfo newContentInfo) {
        log.info("run addContent in ContentsController");
        try {
            contentService.addContent(newContentInfo);
            return new ResponseEntity<>(true, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //https://yeonyeon.tistory.com/33
    //Axios delete 메서드로 body 전달 불가 이슈 url 변경 필수
    @PostMapping(value = "/contentDeleteTest")
    public ResponseEntity<?> deleteContent(@RequestBody DeleteContentInfo deleteContentInfo) {
        log.info("run deleteContent in ContentsController");
        try {
            if (contentService.deleteContent(deleteContentInfo)) {
                return new ResponseEntity<>(true, null, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, null, HttpStatus.OK);
        }
    }
}

package com.sumit.microservices.gita.controller;

import com.sumit.microservices.gita.dto.ShlokaRequest;
import com.sumit.microservices.gita.dto.ShlokaResponse;
import com.sumit.microservices.gita.model.Shloka;
import com.sumit.microservices.gita.service.ShlokaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shloka")
@Slf4j
@RequiredArgsConstructor
public class ShlokaController {

    private final ShlokaService shlokaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shloka addShloka(@RequestBody ShlokaRequest shlokaRequest) {
        return shlokaService.createShloka(shlokaRequest);
    }

    @GetMapping("/chapter/{chapter}/verse/{verse}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ShlokaResponse> getShlokaByChapterAndVerse(@PathVariable("chapter") Integer chapter,
                                                                     @PathVariable("verse") Integer verse) {
        return ResponseEntity.ok().body(shlokaService.getShlokaByChapterAndVerse(chapter, verse));
    }

    @GetMapping("/chapter/{chapter}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ShlokaResponse>> getAllVersesByChapter(@PathVariable("chapter") Integer chapter) {
        return ResponseEntity.ok().body(shlokaService.getAllVersesByChapter(chapter));
    }

    @GetMapping("/findby/chapter/{chapter}/verse/{verse}")
    @ResponseStatus(HttpStatus.OK)
    public boolean doesShlokaExist(@PathVariable("chapter") Integer chapter,
                                   @PathVariable("verse") Integer verse) {
        return shlokaService.doesShlokaExist(chapter, verse);
    }

}

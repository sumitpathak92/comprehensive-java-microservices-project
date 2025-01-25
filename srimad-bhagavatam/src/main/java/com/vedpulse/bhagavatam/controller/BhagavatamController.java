package com.vedpulse.bhagavatam.controller;

import com.vedpulse.bhagavatam.dto.BhagavatamVerseRequest;
import com.vedpulse.bhagavatam.dto.BhagavatamVerseResponse;
import com.vedpulse.bhagavatam.model.BhagavatamVerse;
import com.vedpulse.bhagavatam.service.BhagavatamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bhagavatam/verse")
@Slf4j
@RequiredArgsConstructor
public class BhagavatamController {

    private final BhagavatamService bhagavatamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BhagavatamVerse addVerse(@RequestBody BhagavatamVerseRequest bhagavatamVerseRequest) {
        return bhagavatamService.addBhagavatamVerse(bhagavatamVerseRequest);
    }

    @GetMapping("/canto/{canto}/chapter/{chapter}/verse/{verse}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BhagavatamVerseResponse> getVerseByCantoChapterAndVerseNumber(@PathVariable("canto") Integer canto,
                                                                                        @PathVariable("chapter") Integer chapter,
                                                                                        @PathVariable("verse") Integer verse) {
        return ResponseEntity.ok().body(bhagavatamService.getVerseByCantoAndChapterAndVerseNumber(canto, chapter, verse));
    }

    @GetMapping("/canto/{canto}/chapter/{chapter}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BhagavatamVerseResponse>> getVerseByCantoAndChapter(@PathVariable(
            "canto") Integer canto, @PathVariable("chapter") Integer chapter) {
        return ResponseEntity.ok().body(bhagavatamService.getVersesByCantoAndChapter(canto,
                chapter));
    }

    @GetMapping("/findby/canto/{canto}/chapter/{chapter}")
    @ResponseStatus(HttpStatus.OK)
    public boolean doesShlokaExist(@PathVariable("canto") Integer canto,
                                   @PathVariable("chapter") Integer chapter) {
        return bhagavatamService.doesShlokaExist(canto, chapter);
    }

}

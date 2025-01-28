package com.sumit.microservices.gita.controller;

import com.sumit.microservices.gita.dto.ShlokaRequest;
import com.sumit.microservices.gita.dto.ShlokaResponse;
import com.sumit.microservices.gita.service.ShlokaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/shloka")
@RequiredArgsConstructor
public class ShlokaController {

    private final ShlokaService shlokaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<ResponseEntity<ShlokaResponse>> addShloka(@RequestBody ShlokaRequest shlokaRequest) {
        return CompletableFuture.supplyAsync(() -> shlokaService.createShloka(shlokaRequest).toCompletableFuture().join())
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/chapter/{chapter}/verse/{verse}")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<ResponseEntity<ShlokaResponse>> getShlokaByChapterAndVerse(@PathVariable(
            "chapter") Integer chapter, @PathVariable("verse") Integer verse) {
        return CompletableFuture.supplyAsync(() -> shlokaService.getShlokaByChapterAndVerse(chapter,
                verse).toCompletableFuture().join()).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/chapter/{chapter}")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<ResponseEntity<List<ShlokaResponse>>> getAllVersesByChapter(@PathVariable(
            "chapter") Integer chapter) {
        return CompletableFuture.supplyAsync(() -> shlokaService.getAllVersesByChapter(chapter).toCompletableFuture().join())
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/findby/chapter/{chapter}/verse/{verse}")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<ResponseEntity<Boolean>> doesShlokaExist(@PathVariable("chapter") Integer chapter,
                                   @PathVariable("verse") Integer verse) {
        return CompletableFuture.supplyAsync(() -> shlokaService.doesShlokaExist(chapter, verse).toCompletableFuture().join())
                .thenApply(ResponseEntity::ok);
    }

}

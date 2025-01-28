package com.sumit.microservices.gita.service;


import com.sumit.microservices.gita.dto.ShlokaRequest;
import com.sumit.microservices.gita.dto.ShlokaResponse;
import com.sumit.microservices.gita.model.Shloka;
import com.sumit.microservices.gita.repository.ShlokaSangraha;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@Service
@RequiredArgsConstructor
@Slf4j
public class ShlokaService {

    private final ShlokaSangraha shlokaSangraha;

    public CompletionStage<ShlokaResponse> createShloka(ShlokaRequest shlokaRequest) {
        shlokaSangraha.save(buildShlokaObject(shlokaRequest));
        log.info(":::::: Shloka has been saved :::::: ");
        return CompletableFuture.supplyAsync(() -> buildShlokaResponse(shlokaRequest)); // for now
        // returning just the shloka object instead of ShlokaResponse object
    }

    private static Shloka buildShlokaObject(ShlokaRequest shlokaRequest) {
        return Shloka.builder()
                .chapter(shlokaRequest.chapter())
                .verse(shlokaRequest.verse())
                .shloka(shlokaRequest.shloka())
                .englishText(shlokaRequest.englishText())
                .commentary(shlokaRequest.commentary())
                .translation(shlokaRequest.translation())
                .build();
    }

    private static ShlokaResponse buildShlokaResponse(ShlokaRequest shlokaRequest) {
        return ShlokaResponse.builder()
                .shloka(shlokaRequest.shloka())
                .chapter(shlokaRequest.chapter())
                .verse(shlokaRequest.verse())
                .build();
    }

    public CompletionStage<ShlokaResponse> getShlokaByChapterAndVerse(Integer chapter, Integer verse) {
        log.info(":::::: Shloka has been retrieved :::::::: ");
        return CompletableFuture.supplyAsync(() -> shlokaSangraha.getShlokaByChapterAndVerse(chapter, verse));
    }

    public CompletionStage<List<ShlokaResponse>> getAllVersesByChapter(Integer chapter) {
        log.info(":::::: Shlokas have been retrieved :::::: ");
        return CompletableFuture.supplyAsync(() -> shlokaSangraha.getAllVersesByChapter(chapter));
    }

    public CompletionStage<Boolean> doesShlokaExist(Integer chapter, Integer verse) {
        log.info("::::: Checking if shloka exists :::::");
        return CompletableFuture.supplyAsync(() -> getShlokaByChapterAndVerse(chapter, verse) != null);
    }

}

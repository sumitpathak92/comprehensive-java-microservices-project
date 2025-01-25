package com.sumit.microservices.gita.service;


import com.sumit.microservices.gita.dto.ShlokaRequest;
import com.sumit.microservices.gita.dto.ShlokaResponse;
import com.sumit.microservices.gita.model.Shloka;
import com.sumit.microservices.gita.repository.ShlokaSangraha;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ShlokaService {

    private final ShlokaSangraha shlokaSangraha;

    public Shloka createShloka(ShlokaRequest shlokaRequest) {
        System.out.println("shloka request object ::::  "+shlokaRequest);
        Shloka shloka = Shloka.builder()
                .chapter(shlokaRequest.chapter())
                .verse(shlokaRequest.verse())
                .shloka(shlokaRequest.shloka())
                .englishText(shlokaRequest.englishText())
                .commentary(shlokaRequest.commentary())
                .translation(shlokaRequest.translation())
                .build();

        shlokaSangraha.save(shloka);
        log.info(":::::: Shloka has been saved :::::: {} ", shloka);
        return shloka; // for now returning just the shloka object instead of ShlokaResponse object
    }

    public ShlokaResponse getShlokaByChapterAndVerse(Integer chapter, Integer verse) {
        ShlokaResponse shlokaResponse = shlokaSangraha.getShlokaByChapterAndVerse(chapter, verse);
        log.info(":::::: Shloka has been retrieved :::::: {} ", shlokaResponse);
        return shlokaResponse;
    }

    public List<ShlokaResponse> getAllVersesByChapter(Integer chapter) {
        List<ShlokaResponse> shlokaResponses = shlokaSangraha.getAllVersesByChapter(chapter);
        log.info(":::::: Shlokas have been retrieved :::::: {} ", shlokaResponses);
        return shlokaResponses;
    }

    public boolean doesShlokaExist(Integer chapter, Integer verse) {
        log.info("::::: Checking if shloka exists :::::");
        return getShlokaByChapterAndVerse(chapter, verse) != null;
    }

}

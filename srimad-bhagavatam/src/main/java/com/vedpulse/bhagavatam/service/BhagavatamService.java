package com.vedpulse.bhagavatam.service;

import com.vedpulse.bhagavatam.dto.BhagavatamVerseRequest;
import com.vedpulse.bhagavatam.dto.BhagavatamVerseResponse;
import com.vedpulse.bhagavatam.model.BhagavatamVerse;
import com.vedpulse.bhagavatam.repository.BhagavatamVerseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BhagavatamService {

    private final BhagavatamVerseRepository bhagavatamVerseRepository;

    public BhagavatamVerse addBhagavatamVerse(BhagavatamVerseRequest bhagavatamVerseRequest) {
        BhagavatamVerse bhagavatamVerse = BhagavatamVerse.builder()
                .canto(bhagavatamVerseRequest.canto())
                .verse(bhagavatamVerseRequest.verse())
                .verseNumber(bhagavatamVerseRequest.verseNumber())
                .chapter(bhagavatamVerseRequest.chapter())
                .synonyms(bhagavatamVerseRequest.synonyms())
                .translation(bhagavatamVerseRequest.translation())
                .purport(bhagavatamVerseRequest.purport())
                .build();

        bhagavatamVerseRepository.save(bhagavatamVerse);
        log.info("::::: Verse has been saved ::::: {} ", bhagavatamVerse);
        return bhagavatamVerse;
    }

    public BhagavatamVerseResponse getVerseByCantoAndChapterAndVerseNumber(Integer canto,
                                                                           Integer chapter,
                                                                           Integer verseNumber) {
        BhagavatamVerseResponse bhagavatamVerseResponse =
                bhagavatamVerseRepository.getBhagavatamVerseByCantoAndChapterAndVerseNumber(canto,
                chapter, verseNumber);
        log.info(":::::  Bhagavatam Verse Retrieved ::::: {} ", bhagavatamVerseResponse);
        return bhagavatamVerseResponse;
    }

    public List<BhagavatamVerseResponse> getVersesByCantoAndChapter(Integer canto,
                                                                    Integer chapter) {
        List<BhagavatamVerseResponse> bhagavatamVerseResponses =
                bhagavatamVerseRepository.getBhagavatamVersesByCantoAndChapter(canto, chapter);
        log.info(":::::  Bhagavatam Verses retrieved for canto {} and chapter {} ", canto, chapter);
        return bhagavatamVerseResponses;
    }

    public boolean doesShlokaExist(Integer canto, Integer chapter) {
        log.info("::::: Checking if shloka exists :::::"+!getVersesByCantoAndChapter(canto, chapter).isEmpty());
        return !getVersesByCantoAndChapter(canto, chapter).isEmpty();
    }
}

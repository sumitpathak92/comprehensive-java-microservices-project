package com.vedpulse.bhagavatam.repository;

import com.vedpulse.bhagavatam.dto.BhagavatamVerseResponse;
import com.vedpulse.bhagavatam.model.BhagavatamVerse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BhagavatamVerseRepository extends MongoRepository<BhagavatamVerse, Integer> {

    @Query("{'canto': ?0, 'chapter': ?1, 'verseNumber': ?2}")
    BhagavatamVerseResponse getBhagavatamVerseByCantoAndChapterAndVerseNumber(Integer canto, Integer chapter, Integer verseNumber);

    @Query("{'canto': ?0, 'chapter': ?1}")
    List<BhagavatamVerseResponse> getBhagavatamVersesByCantoAndChapter(Integer canto,
                                                                      Integer chapter);

}

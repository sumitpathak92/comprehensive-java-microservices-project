package com.sumit.microservices.gita.repository;

import com.sumit.microservices.gita.dto.ShlokaResponse;
import com.sumit.microservices.gita.model.Shloka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ShlokaSangraha extends MongoRepository<Shloka, Integer> {

    @Query("{ 'chapter': ?0, 'verse': ?1 }")
    ShlokaResponse getShlokaByChapterAndVerse(Integer chapter, Integer verse);

    @Query("{ 'chapter': ?0 }")
    List<ShlokaResponse> getAllVersesByChapter(Integer chapter);


}

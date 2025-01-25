package com.vedpulse.bhagavatam.dto;

public record BhagavatamVerseResponse(Integer canto, Integer chapter, Integer verseNumber,
                                        String verse, String synonyms, String translation, String purport) {}

package com.sumit.microservices.gita.dto;

public record ShlokaResponse(Integer chapter, Integer verse, String shloka, String englishText,
                                String translation, String commentary) {}


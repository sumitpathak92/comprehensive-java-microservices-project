package com.sumit.microservices.gita.dto;

public record ShlokaRequest(Integer chapter, Integer verse, String shloka, String englishText,
                            String translation, String commentary) {}

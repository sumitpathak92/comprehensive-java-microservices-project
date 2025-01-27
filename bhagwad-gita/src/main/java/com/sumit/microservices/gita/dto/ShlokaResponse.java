package com.sumit.microservices.gita.dto;

import lombok.Builder;

@Builder
public record ShlokaResponse(Integer chapter, Integer verse, String shloka) {}


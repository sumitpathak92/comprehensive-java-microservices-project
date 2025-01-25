package com.vedpulse.bhagavatam.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "all-cantos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BhagavatamVerse {

    private Integer canto;
    private Integer chapter;
    private Integer verseNumber;
    private String verse;
    private String synonyms;
    private String translation;
    private String purport;

}

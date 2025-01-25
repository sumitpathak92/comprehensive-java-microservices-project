package com.sumit.microservices.gita.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "shlokas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shloka {

    private Integer chapter;
    private Integer verse;
    private String shloka;
    private String englishText;
    private String translation;
    private String commentary;

}

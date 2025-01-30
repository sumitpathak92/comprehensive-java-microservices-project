package com.sumit.microservices.gita.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShlokaEvent {

    private Integer chapter;
    private Integer verse;
    private String shloka;
    private String englishText;
    private String translation;
    private String commentary;

}

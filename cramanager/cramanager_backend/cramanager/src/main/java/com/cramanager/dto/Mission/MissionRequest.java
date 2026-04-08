package com.cramanager.dto.Mission;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MissionRequest {
    private String titre;
    private LocalDate datedebut;
    private LocalDate datefin;
    private String description;
    private String motif;
    private BigDecimal tjm;
}

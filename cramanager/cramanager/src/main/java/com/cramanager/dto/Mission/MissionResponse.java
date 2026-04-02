package com.cramanager.dto.Mission;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MissionResponse {
    private Long id;
    private String titre;
    private LocalDate datedebut;
    private LocalDate datefin;
    private String description;
    private String motif;
    private BigDecimal tjm;
}

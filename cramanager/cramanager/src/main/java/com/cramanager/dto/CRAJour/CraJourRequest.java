package com.cramanager.dto.CRAJour;

import com.cramanager.enumeration.TypeAbsence;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CraJourRequest {
    private LocalDate jour;
    private TypeAbsence type;
}

package com.cramanager.dto.CRAJour;

import com.cramanager.entity.CRA;
import com.cramanager.enumeration.TypeAbsence;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CraJourResponse {

    private Long id;
    private Long craid;
    private LocalDate jour;
    private TypeAbsence type;

}

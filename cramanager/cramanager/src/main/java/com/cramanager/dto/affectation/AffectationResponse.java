package com.cramanager.dto.affectation;

import com.cramanager.entity.Mission;
import com.cramanager.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AffectationResponse {

    private Long id;
    private Long missionid;
    private Long userid;
    private LocalDate dateAffectation;

}

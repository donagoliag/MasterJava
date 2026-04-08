package com.cramanager.dto.affectation;

import com.cramanager.entity.Mission;
import com.cramanager.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AffectationRequest {

    private Long missionid;
    private Long userid;


}

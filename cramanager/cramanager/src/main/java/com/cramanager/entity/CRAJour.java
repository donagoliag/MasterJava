package com.cramanager.entity;


import com.cramanager.enumeration.TypeAbsence;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.MonthDay;

@Entity
@Table(name="CRAjour")
public class CRAJour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private MonthDay jourdumois;
    private TypeAbsence typeAbsence;
}

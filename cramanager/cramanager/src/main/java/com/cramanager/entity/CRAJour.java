package com.cramanager.entity;


import com.cramanager.enumeration.EtatCRA;
import com.cramanager.enumeration.TypeAbsence;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.MonthDay;

@Data
@Entity
@Table(name="CRAjour")
public class CRAJour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cra_id", nullable = false)
    private CRA cra;

    @Column(nullable = false)
    private LocalDate jour;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeAbsence type;
}

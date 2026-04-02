package com.cramanager.repository;

import com.cramanager.entity.CRA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CraRepository extends JpaRepository<CRA,Long> {
    Optional<CRA> findByUserIdAndMoisAndAnnee (Long userId, int mois, int annee);
    List<CRA> findByUserId(Long userId);
}

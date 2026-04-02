package com.cramanager.repository;

import com.cramanager.entity.Affectation;
import com.cramanager.entity.CRA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AffectationRepository extends JpaRepository <Affectation,Long>{
    Optional<Affectation> findByUserId(Long userId);
}

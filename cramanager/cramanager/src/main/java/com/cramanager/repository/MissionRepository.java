package com.cramanager.repository;

import com.cramanager.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission,Long> {

}

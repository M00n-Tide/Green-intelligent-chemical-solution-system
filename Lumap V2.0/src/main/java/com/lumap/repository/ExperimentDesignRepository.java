package com.lumap.repository;

import com.lumap.entity.ExperimentDesign;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperimentDesignRepository extends JpaRepository<ExperimentDesign, Long> {
    List<ExperimentDesign> findByCreatorId(Long creatorId);
    List<ExperimentDesign> findByStatus(ExperimentDesign.Status status);
}
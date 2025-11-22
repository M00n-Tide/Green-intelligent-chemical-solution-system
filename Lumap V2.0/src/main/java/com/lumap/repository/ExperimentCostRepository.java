package com.lumap.repository;

import com.lumap.entity.ExperimentCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ExperimentCostRepository extends JpaRepository<ExperimentCost, Long> {
    List<ExperimentCost> findByExperimentRecordId(Long experimentRecordId);
    
    List<ExperimentCost> findByCostCategory(String costCategory);
    
    @Query("SELECT SUM(ec.totalCost) FROM ExperimentCost ec WHERE ec.experimentRecordId = :recordId")
    BigDecimal sumTotalCostByExperimentRecordId(@Param("recordId") Long recordId);
    
    @Query("SELECT ec.costCategory, SUM(ec.totalCost) as total FROM ExperimentCost ec WHERE ec.experimentRecordId = :recordId GROUP BY ec.costCategory")
    List<Object[]> sumCostByCategoryByExperimentRecordId(@Param("recordId") Long recordId);
}
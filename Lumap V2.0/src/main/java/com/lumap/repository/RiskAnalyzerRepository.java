package com.lumap.repository;

import com.lumap.entity.RiskAnalyzer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RiskAnalyzerRepository extends JpaRepository<RiskAnalyzer, Long> {
    List<RiskAnalyzer> findByChemId(Long chemId);
    List<RiskAnalyzer> findByRiskType(String riskType);
}
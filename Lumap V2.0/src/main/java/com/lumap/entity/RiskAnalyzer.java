package com.lumap.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_analyzer")
public class RiskAnalyzer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "chem_id")
    private Long chemId;
    
    private String riskType;
    
    private Integer riskLevel;
    
    @Column(name = "analysis_time")
    private LocalDateTime analysisTime;
    
    private String suggestion;

    // 无参构造函数
    public RiskAnalyzer() {}

    // 带参构造函数
    public RiskAnalyzer(Long chemId, String riskType, Integer riskLevel) {
        this.chemId = chemId;
        this.riskType = riskType;
        this.riskLevel = riskLevel;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getChemId() { return chemId; }
    public void setChemId(Long chemId) { this.chemId = chemId; }
    
    public String getRiskType() { return riskType; }
    public void setRiskType(String riskType) { this.riskType = riskType; }
    
    public Integer getRiskLevel() { return riskLevel; }
    public void setRiskLevel(Integer riskLevel) { this.riskLevel = riskLevel; }
    
    public LocalDateTime getAnalysisTime() { return analysisTime; }
    public void setAnalysisTime(LocalDateTime analysisTime) { this.analysisTime = analysisTime; }
    
    public String getSuggestion() { return suggestion; }
    public void setSuggestion(String suggestion) { this.suggestion = suggestion; }
}
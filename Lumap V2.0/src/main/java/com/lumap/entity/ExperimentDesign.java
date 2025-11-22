package com.lumap.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "experiment_design")
public class ExperimentDesign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "design_name")
    private String designName;
    
    @Column(name = "creator_id")
    private Long creatorId;
    
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name = "experiment_steps", length = 1000)
    private String experimentSteps;
    
    private String reagents;
    
    @Column(name = "safety_notes")
    private String safetyNotes;

    public enum Status { 草稿, 已提交, 已审核 }

    // 无参构造函数
    public ExperimentDesign() {}

    // 带参构造函数
    public ExperimentDesign(String designName, Long creatorId) {
        this.designName = designName;
        this.creatorId = creatorId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDesignName() { return designName; }
    public void setDesignName(String designName) { this.designName = designName; }
    
    public Long getCreatorId() { return creatorId; }
    public void setCreatorId(Long creatorId) { this.creatorId = creatorId; }
    
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
    
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    
    public String getExperimentSteps() { return experimentSteps; }
    public void setExperimentSteps(String experimentSteps) { this.experimentSteps = experimentSteps; }
    
    public String getReagents() { return reagents; }
    public void setReagents(String reagents) { this.reagents = reagents; }
    
    public String getSafetyNotes() { return safetyNotes; }
    public void setSafetyNotes(String safetyNotes) { this.safetyNotes = safetyNotes; }
}
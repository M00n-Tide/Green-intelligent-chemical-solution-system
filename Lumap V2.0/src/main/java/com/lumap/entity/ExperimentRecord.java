package com.lumap.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "experiment_record")
public class ExperimentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "design_id")
    private Long designId;
    
    @Column(name = "executor_id")
    private Long executorId;
    
    @Column(name = "exec_time")
    private LocalDateTime execTime;
    
    private String result;
    
    @Column(name = "used_reagents")
    private String usedReagents;

    // 无参构造函数
    public ExperimentRecord() {}

    // 带参构造函数
    public ExperimentRecord(Long designId, Long executorId) {
        this.designId = designId;
        this.executorId = executorId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getDesignId() { return designId; }
    public void setDesignId(Long designId) { this.designId = designId; }
    
    public Long getExecutorId() { return executorId; }
    public void setExecutorId(Long executorId) { this.executorId = executorId; }
    
    public LocalDateTime getExecTime() { return execTime; }
    public void setExecTime(LocalDateTime execTime) { this.execTime = execTime; }
    
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    
    public String getUsedReagents() { return usedReagents; }
    public void setUsedReagents(String usedReagents) { this.usedReagents = usedReagents; }
}
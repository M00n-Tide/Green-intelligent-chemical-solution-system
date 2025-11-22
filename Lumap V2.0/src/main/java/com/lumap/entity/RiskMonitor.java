package com.lumap.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_monitor")
public class RiskMonitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "analyzer_id")
    private Long analyzerId;
    
    @Enumerated(EnumType.STRING)
    private MonitorStatus monitorStatus;
    
    @Column(name = "last_check_time")
    private LocalDateTime lastCheckTime;
    
    private String threshold;

    public enum MonitorStatus { 运行中, 已停止, 告警 }

    // 无参构造函数
    public RiskMonitor() {}

    // 带参构造函数
    public RiskMonitor(Long analyzerId, MonitorStatus monitorStatus, String threshold) {
        this.analyzerId = analyzerId;
        this.monitorStatus = monitorStatus;
        this.threshold = threshold;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getAnalyzerId() { return analyzerId; }
    public void setAnalyzerId(Long analyzerId) { this.analyzerId = analyzerId; }
    
    public MonitorStatus getMonitorStatus() { return monitorStatus; }
    public void setMonitorStatus(MonitorStatus monitorStatus) { this.monitorStatus = monitorStatus; }
    
    public LocalDateTime getLastCheckTime() { return lastCheckTime; }
    public void setLastCheckTime(LocalDateTime lastCheckTime) { this.lastCheckTime = lastCheckTime; }
    
    public String getThreshold() { return threshold; }
    public void setThreshold(String threshold) { this.threshold = threshold; }
}
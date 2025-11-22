package com.lumap.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "safety_datasheet")
public class SafetyDatasheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "chem_id")
    private Long chemId;
    
    private String version;
    
    @Column(name = "effective_date")
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;
    
    @Column(name = "document_path")
    private String documentPath;
    
    @Column(name = "file_format")
    private String fileFormat;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    public enum Status { 生效, 失效, 草稿 }

    // 无参构造函数
    public SafetyDatasheet() {}

    // 带参构造函数
    public SafetyDatasheet(Long chemId, String version) {
        this.chemId = chemId;
        this.version = version;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getChemId() { return chemId; }
    public void setChemId(Long chemId) { this.chemId = chemId; }
    
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    
    public Date getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(Date effectiveDate) { this.effectiveDate = effectiveDate; }
    
    public String getDocumentPath() { return documentPath; }
    public void setDocumentPath(String documentPath) { this.documentPath = documentPath; }
    
    public String getFileFormat() { return fileFormat; }
    public void setFileFormat(String fileFormat) { this.fileFormat = fileFormat; }
    
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    
    public Date getCreatedTime() { return createdTime; }
    public void setCreatedTime(Date createdTime) { this.createdTime = createdTime; }
}
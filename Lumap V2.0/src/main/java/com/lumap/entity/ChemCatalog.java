package com.lumap.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chem_catalog")
public class ChemCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "chemical_name", nullable = false)
    private String chemicalName;
    
    @Column(name = "cas_number", nullable = false, unique = true)
    private String casNumber;
    
    @Column(name = "molecular_formula")
    private String molecularFormula;
    
    @Column(name = "create_time")
    private LocalDateTime createTime;
    
    @Column(name = "update_time")
    private LocalDateTime updateTime;
    
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;
    
    @Column(name = "category_code")
    private String categoryCode;
    
    @Enumerated(EnumType.STRING)
    private HazardLevel hazardLevel;
    
    @Column(name = "storage_condition")
    private String storageCondition;

    public enum RecordStatus { 启用, 停用, 草稿 }
    public enum HazardLevel { 无危险, 低危, 中危, 高危 }

    // 无参构造函数
    public ChemCatalog() {}

    // 带参构造函数
    public ChemCatalog(String chemicalName, String casNumber) {
        this.chemicalName = chemicalName;
        this.casNumber = casNumber;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getChemicalName() { return chemicalName; }
    public void setChemicalName(String chemicalName) { this.chemicalName = chemicalName; }
    
    public String getCasNumber() { return casNumber; }
    public void setCasNumber(String casNumber) { this.casNumber = casNumber; }
    
    public String getMolecularFormula() { return molecularFormula; }
    public void setMolecularFormula(String molecularFormula) { this.molecularFormula = molecularFormula; }
    
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
    
    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }
    
    public RecordStatus getRecordStatus() { return recordStatus; }
    public void setRecordStatus(RecordStatus recordStatus) { this.recordStatus = recordStatus; }
    
    public String getCategoryCode() { return categoryCode; }
    public void setCategoryCode(String categoryCode) { this.categoryCode = categoryCode; }
    
    public HazardLevel getHazardLevel() { return hazardLevel; }
    public void setHazardLevel(HazardLevel hazardLevel) { this.hazardLevel = hazardLevel; }
    
    public String getStorageCondition() { return storageCondition; }
    public void setStorageCondition(String storageCondition) { this.storageCondition = storageCondition; }
}
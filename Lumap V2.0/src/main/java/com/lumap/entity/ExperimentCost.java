package com.lumap.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "experiment_cost")
public class ExperimentCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "experiment_record_id")
    private Long experimentRecordId;
    
    @Column(name = "cost_category")
    private String costCategory;
    
    @Column(name = "item_name")
    private String itemName;
    
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    
    @Column(name = "quantity")
    private BigDecimal quantity;
    
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    // 无参构造函数
    public ExperimentCost() {}

    // 带参构造函数
    public ExperimentCost(Long experimentRecordId, String costCategory, String itemName, 
                      BigDecimal unitPrice, BigDecimal quantity, String currency) {
        this.experimentRecordId = experimentRecordId;
        this.costCategory = costCategory;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.currency = currency;
        this.createdTime = LocalDateTime.now();
        calculateTotalCost();
    }

    // 计算总成本
    public void calculateTotalCost() {
        if (unitPrice != null && quantity != null) {
            this.totalCost = unitPrice.multiply(quantity);
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getExperimentRecordId() { return experimentRecordId; }
    public void setExperimentRecordId(Long experimentRecordId) { this.experimentRecordId = experimentRecordId; }
    
    public String getCostCategory() { return costCategory; }
    public void setCostCategory(String costCategory) { this.costCategory = costCategory; }
    
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    
    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
}
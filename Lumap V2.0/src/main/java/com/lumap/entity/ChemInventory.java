package com.lumap.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chem_inventory")
public class ChemInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "chem_catalog_id")
    private Long catalogId;
    
    @Column(name = "inventory_quantity")
    private Double quantity;
    
    @Column(name = "storage_location")
    private String location;
    
    @Column(name = "storage_temp")
    private String temperature;
    
    @Column(name = "container_type")
    private String containerType;
    
    @Enumerated(EnumType.STRING)
    private InventoryStatus status;
    
    @Column(name = "last_update_time")
    private LocalDateTime updateTime;

    public enum InventoryStatus { NORMAL, BELOW_SAFE, EXPIRED }

    // 无参构造函数
    public ChemInventory() {}

    // 带参构造函数
    public ChemInventory(Long catalogId, Double quantity, String location) {
        this.catalogId = catalogId;
        this.quantity = quantity;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getCatalogId() { return catalogId; }
    public void setCatalogId(Long catalogId) { this.catalogId = catalogId; }
    
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }
    
    public String getContainerType() { return containerType; }
    public void setContainerType(String containerType) { this.containerType = containerType; }
    
    public InventoryStatus getStatus() { return status; }
    public void setStatus(InventoryStatus status) { this.status = status; }
    
    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }
}
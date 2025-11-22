package com.lumap.service;

import com.lumap.entity.ChemCatalog;
import com.lumap.entity.ChemInventory;
import com.lumap.repository.ChemCatalogRepository;
import com.lumap.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChemicalManagementService {
    private final ChemCatalogRepository catalogRepo;
    private final InventoryRepository inventoryRepo;

    public ChemicalManagementService(ChemCatalogRepository catalogRepo, InventoryRepository inventoryRepo) {
        this.catalogRepo = catalogRepo;
        this.inventoryRepo = inventoryRepo;
    }

    // 获取所有化学品目录
    public List<ChemCatalog> getAllCatalogs() {
        return catalogRepo.findAll();
    }

    // 根据ID获取化学品目录
    public Optional<ChemCatalog> getCatalogById(Long id) {
        return catalogRepo.findById(id);
    }

    // 创建化学品目录
    public ChemCatalog createCatalog(ChemCatalog catalog) {
        catalog.setCreateTime(LocalDateTime.now());
        catalog.setRecordStatus(ChemCatalog.RecordStatus.草稿);
        return catalogRepo.save(catalog);
    }

    // 更新化学品目录
    public Optional<ChemCatalog> updateCatalog(Long id, ChemCatalog updated) {
        return catalogRepo.findById(id).map(catalog -> {
            catalog.setChemicalName(updated.getChemicalName());
            catalog.setMolecularFormula(updated.getMolecularFormula());
            catalog.setRecordStatus(updated.getRecordStatus());
            catalog.setCategoryCode(updated.getCategoryCode());
            catalog.setHazardLevel(updated.getHazardLevel());
            catalog.setStorageCondition(updated.getStorageCondition());
            catalog.setUpdateTime(LocalDateTime.now());
            return catalogRepo.save(catalog);
        });
    }

    // 获取指定化学品的库存信息
    public List<ChemInventory> getInventoryByCatalogId(Long catalogId) {
        return inventoryRepo.findByCatalogId(catalogId);
    }

    // 添加库存
    public ChemInventory addInventory(ChemInventory inventory) {
        inventory.setUpdateTime(LocalDateTime.now());
        return inventoryRepo.save(inventory);
    }

    // 减少库存
    public Optional<ChemInventory> reduceInventory(Long id, Double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be positive");
        }
        return inventoryRepo.findById(id).map(inv -> {
            if (inv.getQuantity() < amount) throw new RuntimeException("Insufficient inventory");
            inv.setQuantity(inv.getQuantity() - amount);
            if (inv.getQuantity() <= 0) inv.setStatus(ChemInventory.InventoryStatus.BELOW_SAFE);
            return inventoryRepo.save(inv);
        });
    }

    // 获取所有库存
    public List<ChemInventory> getAllInventory() {
        return inventoryRepo.findAll();
    }
}
package com.lumap.repository;

import com.lumap.entity.ChemInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InventoryRepository extends JpaRepository<ChemInventory, Long> {
    List<ChemInventory> findByCatalogId(Long catalogId);
    List<ChemInventory> findByStatus(ChemInventory.InventoryStatus status);
}
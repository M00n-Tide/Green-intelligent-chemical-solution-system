package com.lumap.repository;

import com.lumap.entity.ChemCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChemCatalogRepository extends JpaRepository<ChemCatalog, Long> {
    ChemCatalog findByCasNumber(String casNumber);
    List<ChemCatalog> findByRecordStatus(ChemCatalog.RecordStatus status);
    List<ChemCatalog> findByHazardLevel(ChemCatalog.HazardLevel hazardLevel);
}
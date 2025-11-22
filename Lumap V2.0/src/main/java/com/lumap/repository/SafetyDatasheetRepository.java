package com.lumap.repository;

import com.lumap.entity.SafetyDatasheet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SafetyDatasheetRepository extends JpaRepository<SafetyDatasheet, Long> {
    List<SafetyDatasheet> findByChemId(Long chemId);
    List<SafetyDatasheet> findByStatus(SafetyDatasheet.Status status);
}
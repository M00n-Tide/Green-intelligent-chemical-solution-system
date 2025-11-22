package com.lumap.repository;

import com.lumap.entity.ExperimentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperimentRecordRepository extends JpaRepository<ExperimentRecord, Long> {
    List<ExperimentRecord> findByDesignId(Long designId);
    List<ExperimentRecord> findByExecutorId(Long executorId);
}
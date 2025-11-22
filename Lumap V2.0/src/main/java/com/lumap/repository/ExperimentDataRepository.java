package com.lumap.repository;

import com.lumap.entity.ExperimentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ExperimentDataRepository extends JpaRepository<ExperimentData, Long> {
    List<ExperimentData> findByExperimentRecordId(Long experimentRecordId);
    
    List<ExperimentData> findByParameterName(String parameterName);
    
    List<ExperimentData> findByExperimentRecordIdAndParameterName(Long experimentRecordId, String parameterName);
    
    @Query("SELECT ed FROM ExperimentData ed WHERE ed.experimentRecordId = :recordId ORDER BY ed.measurementTime ASC")
    List<ExperimentData> findByExperimentRecordIdOrderByTime(@Param("recordId") Long recordId);
    
    @Query("SELECT AVG(ed.measurementValue) FROM ExperimentData ed WHERE ed.experimentRecordId = :recordId AND ed.parameterName = :paramName")
    BigDecimal getAverageValueByRecordIdAndParameterName(@Param("recordId") Long recordId, @Param("paramName") String paramName);
    
    @Query("SELECT MAX(ed.measurementValue) FROM ExperimentData ed WHERE ed.experimentRecordId = :recordId AND ed.parameterName = :paramName")
    BigDecimal getMaxValueByRecordIdAndParameterName(@Param("recordId") Long recordId, @Param("paramName") String paramName);
    
    @Query("SELECT MIN(ed.measurementValue) FROM ExperimentData ed WHERE ed.experimentRecordId = :recordId AND ed.parameterName = :paramName")
    BigDecimal getMinValueByRecordIdAndParameterName(@Param("recordId") Long recordId, @Param("paramName") String paramName);
}
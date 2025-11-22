package com.lumap.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "experiment_data")
public class ExperimentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "experiment_record_id")
    private Long experimentRecordId;
    
    @Column(name = "parameter_name")
    private String parameterName;
    
    @Column(name = "parameter_unit")
    private String parameterUnit;
    
    @Column(name = "measurement_value")
    private BigDecimal measurementValue;
    
    @Column(name = "expected_value")
    private BigDecimal expectedValue;
    
    @Column(name = "deviation")
    private BigDecimal deviation;
    
    @Column(name = "measurement_time")
    private LocalDateTime measurementTime;
    
    @Column(name = "notes")
    private String notes;
    
    @Column(name = "data_type")
    private String dataType; // 数值型、文本型、图表型等

    // 无参构造函数
    public ExperimentData() {}

    // 带参构造函数
    public ExperimentData(Long experimentRecordId, String parameterName, String parameterUnit, 
                       BigDecimal measurementValue, BigDecimal expectedValue, String dataType) {
        this.experimentRecordId = experimentRecordId;
        this.parameterName = parameterName;
        this.parameterUnit = parameterUnit;
        this.measurementValue = measurementValue;
        this.expectedValue = expectedValue;
        this.dataType = dataType;
        this.measurementTime = LocalDateTime.now();
        calculateDeviation();
    }

    // 计算偏差
    public void calculateDeviation() {
        if (measurementValue != null && expectedValue != null) {
            this.deviation = measurementValue.subtract(expectedValue);
        }
    }

    // 计算偏差百分比
    public BigDecimal getDeviationPercentage() {
        if (deviation != null && expectedValue != null && expectedValue.compareTo(BigDecimal.ZERO) != 0) {
            return deviation.divide(expectedValue, 4, BigDecimal.ROUND_HALF_UP)
                    .multiply(new BigDecimal("100"));
        }
        return BigDecimal.ZERO;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getExperimentRecordId() { return experimentRecordId; }
    public void setExperimentRecordId(Long experimentRecordId) { this.experimentRecordId = experimentRecordId; }
    
    public String getParameterName() { return parameterName; }
    public void setParameterName(String parameterName) { this.parameterName = parameterName; }
    
    public String getParameterUnit() { return parameterUnit; }
    public void setParameterUnit(String parameterUnit) { this.parameterUnit = parameterUnit; }
    
    public BigDecimal getMeasurementValue() { return measurementValue; }
    public void setMeasurementValue(BigDecimal measurementValue) { 
        this.measurementValue = measurementValue;
        calculateDeviation();
    }
    
    public BigDecimal getExpectedValue() { return expectedValue; }
    public void setExpectedValue(BigDecimal expectedValue) { 
        this.expectedValue = expectedValue;
        calculateDeviation();
    }
    
    public BigDecimal getDeviation() { return deviation; }
    public void setDeviation(BigDecimal deviation) { this.deviation = deviation; }
    
    public LocalDateTime getMeasurementTime() { return measurementTime; }
    public void setMeasurementTime(LocalDateTime measurementTime) { this.measurementTime = measurementTime; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType; }
}
package com.lumap.service;

import com.lumap.entity.ExperimentData;
import com.lumap.repository.ExperimentDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExperimentDataService {
    private final ExperimentDataRepository dataRepo;

    public ExperimentDataService(ExperimentDataRepository dataRepo) {
        this.dataRepo = dataRepo;
    }

    // 添加实验数据
    public ExperimentData addExperimentData(ExperimentData data) {
        data.calculateDeviation();
        return dataRepo.save(data);
    }

    // 批量添加实验数据
    public List<ExperimentData> addExperimentDataBatch(List<ExperimentData> dataList) {
        dataList.forEach(ExperimentData::calculateDeviation);
        return dataRepo.saveAll(dataList);
    }

    // 获取实验的所有数据
    public List<ExperimentData> getExperimentDataByRecordId(Long experimentRecordId) {
        return dataRepo.findByExperimentRecordIdOrderByTime(experimentRecordId);
    }

    // 获取特定参数的所有数据点
    public List<ExperimentData> getDataByParameterName(Long experimentRecordId, String parameterName) {
        return dataRepo.findByExperimentRecordIdAndParameterName(experimentRecordId, parameterName);
    }

    // 获取参数统计信息
    public Map<String, Object> getParameterStatistics(Long experimentRecordId, String parameterName) {
        Map<String, Object> statistics = new HashMap<>();
        
        List<ExperimentData> dataPoints = getDataByParameterName(experimentRecordId, parameterName);
        
        if (dataPoints.isEmpty()) {
            return statistics;
        }
        
        BigDecimal sum = dataPoints.stream()
                .map(ExperimentData::getMeasurementValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        BigDecimal average = sum.divide(new BigDecimal(dataPoints.size()), 4, BigDecimal.ROUND_HALF_UP);
        BigDecimal max = dataRepo.getMaxValueByRecordIdAndParameterName(experimentRecordId, parameterName);
        BigDecimal min = dataRepo.getMinValueByRecordIdAndParameterName(experimentRecordId, parameterName);
        
        statistics.put("parameterName", parameterName);
        statistics.put("dataPoints", dataPoints.size());
        statistics.put("sum", sum);
        statistics.put("average", average);
        statistics.put("max", max);
        statistics.put("min", min);
        statistics.put("data", dataPoints);
        
        return statistics;
    }

    // 获取实验数据的完整分析
    public Map<String, Object> getExperimentDataAnalysis(Long experimentRecordId) {
        Map<String, Object> analysis = new HashMap<>();
        
        List<ExperimentData> allData = getExperimentDataByRecordId(experimentRecordId);
        
        // 获取所有不同的参数名称
        List<String> parameterNames = allData.stream()
                .map(ExperimentData::getParameterName)
                .distinct()
                .collect(Collectors.toList());
        
        // 为每个参数生成统计信息
        Map<String, Object> parameterStatistics = new HashMap<>();
        for (String paramName : parameterNames) {
            parameterStatistics.put(paramName, getParameterStatistics(experimentRecordId, paramName));
        }
        
        analysis.put("experimentRecordId", experimentRecordId);
        analysis.put("totalDataPoints", allData.size());
        analysis.put("parameterCount", parameterNames.size());
        analysis.put("parameterNames", parameterNames);
        analysis.put("parameters", parameterStatistics);
        
        return analysis;
    }

    // 更新实验数据
    public ExperimentData updateExperimentData(Long id, ExperimentData updatedData) {
        return dataRepo.findById(id)
                .map(data -> {
                    data.setParameterName(updatedData.getParameterName());
                    data.setParameterUnit(updatedData.getParameterUnit());
                    data.setMeasurementValue(updatedData.getMeasurementValue());
                    data.setExpectedValue(updatedData.getExpectedValue());
                    data.setNotes(updatedData.getNotes());
                    data.setDataType(updatedData.getDataType());
                    data.calculateDeviation();
                    return dataRepo.save(data);
                })
                .orElseThrow(() -> new RuntimeException("Experiment data not found"));
    }

    // 删除实验数据
    public void deleteExperimentData(Long id) {
        dataRepo.deleteById(id);
    }
}
package com.lumap.controller;

import com.lumap.entity.ExperimentData;
import com.lumap.service.ExperimentDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/experiments/data")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExperimentDataController {
    private final ExperimentDataService dataService;

    public ExperimentDataController(ExperimentDataService dataService) {
        this.dataService = dataService;
    }

    // 获取实验的所有数据
    @GetMapping("/experiment/{experimentRecordId}")
    public List<ExperimentData> getExperimentDataByRecordId(@PathVariable Long experimentRecordId) {
        return dataService.getExperimentDataByRecordId(experimentRecordId);
    }

    // 获取特定参数的所有数据点
    @GetMapping("/experiment/{experimentRecordId}/parameter/{parameterName}")
    public List<ExperimentData> getDataByParameterName(@PathVariable Long experimentRecordId, 
                                                    @PathVariable String parameterName) {
        return dataService.getDataByParameterName(experimentRecordId, parameterName);
    }

    // 获取参数统计信息
    @GetMapping("/statistics/{experimentRecordId}/parameter/{parameterName}")
    public Map<String, Object> getParameterStatistics(@PathVariable Long experimentRecordId, 
                                                @PathVariable String parameterName) {
        return dataService.getParameterStatistics(experimentRecordId, parameterName);
    }

    // 获取实验数据的完整分析
    @GetMapping("/analysis/{experimentRecordId}")
    public Map<String, Object> getExperimentDataAnalysis(@PathVariable Long experimentRecordId) {
        return dataService.getExperimentDataAnalysis(experimentRecordId);
    }

    // 添加实验数据
    @PostMapping
    public ExperimentData addExperimentData(@RequestBody ExperimentData data) {
        return dataService.addExperimentData(data);
    }

    // 批量添加实验数据
    @PostMapping("/batch")
    public List<ExperimentData> addExperimentDataBatch(@RequestBody List<ExperimentData> dataList) {
        return dataService.addExperimentDataBatch(dataList);
    }

    // 更新实验数据
    @PutMapping("/{id}")
    public ExperimentData updateExperimentData(@PathVariable Long id, @RequestBody ExperimentData data) {
        return dataService.updateExperimentData(id, data);
    }

    // 删除实验数据
    @DeleteMapping("/{id}")
    public Map<String, String> deleteExperimentData(@PathVariable Long id) {
        dataService.deleteExperimentData(id);
        return Map.of("message", "Experiment data deleted successfully");
    }
}
package com.lumap.controller;

import com.lumap.entity.ExperimentCost;
import com.lumap.service.ExperimentCostService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/experiments/costs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExperimentCostController {
    private final ExperimentCostService costService;

    public ExperimentCostController(ExperimentCostService costService) {
        this.costService = costService;
    }

    // 获取实验的所有成本项
    @GetMapping("/experiment/{experimentRecordId}")
    public List<ExperimentCost> getCostItemsByExperimentRecordId(@PathVariable Long experimentRecordId) {
        return costService.getCostItemsByExperimentRecordId(experimentRecordId);
    }

    // 计算实验总成本
    @GetMapping("/total/{experimentRecordId}")
    public Map<String, Object> getTotalCost(@PathVariable Long experimentRecordId) {
        BigDecimal totalCost = costService.calculateTotalCost(experimentRecordId);
        Map<String, Object> result = Map.of(
                "experimentRecordId", experimentRecordId,
                "totalCost", totalCost
        );
        return result;
    }

    // 按类别统计成本
    @GetMapping("/category/{experimentRecordId}")
    public Map<String, BigDecimal> getCostByCategory(@PathVariable Long experimentRecordId) {
        return costService.getCostByCategory(experimentRecordId);
    }

    // 添加成本项
    @PostMapping
    public ExperimentCost addCostItem(@RequestBody ExperimentCost cost) {
        return costService.addCostItem(cost);
    }

    // 更新成本项
    @PutMapping("/{id}")
    public ExperimentCost updateCostItem(@PathVariable Long id, @RequestBody ExperimentCost cost) {
        return costService.updateCostItem(id, cost);
    }

    // 删除成本项
    @DeleteMapping("/{id}")
    public Map<String, String> deleteCostItem(@PathVariable Long id) {
        costService.deleteCostItem(id);
        return Map.of("message", "Cost item deleted successfully");
    }

    // 估算实验成本
    @PostMapping("/estimate/{experimentDesignId}")
    public Map<String, Object> estimateExperimentCost(@PathVariable Long experimentDesignId, 
                                                 @RequestBody Map<String, BigDecimal> reagentQuantities) {
        BigDecimal estimatedCost = costService.estimateExperimentCost(experimentDesignId, reagentQuantities);
        return Map.of(
                "experimentDesignId", experimentDesignId,
                "estimatedCost", estimatedCost
        );
    }
}
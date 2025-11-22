package com.lumap.service;

import com.lumap.entity.ExperimentCost;
import com.lumap.repository.ExperimentCostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExperimentCostService {
    private final ExperimentCostRepository costRepo;

    public ExperimentCostService(ExperimentCostRepository costRepo) {
        this.costRepo = costRepo;
    }

    // 添加成本项
    public ExperimentCost addCostItem(ExperimentCost cost) {
        cost.calculateTotalCost();
        return costRepo.save(cost);
    }

    // 获取实验的所有成本项
    public List<ExperimentCost> getCostItemsByExperimentRecordId(Long experimentRecordId) {
        return costRepo.findByExperimentRecordId(experimentRecordId);
    }

    // 计算实验总成本
    public BigDecimal calculateTotalCost(Long experimentRecordId) {
        BigDecimal total = costRepo.sumTotalCostByExperimentRecordId(experimentRecordId);
        return total != null ? total : BigDecimal.ZERO;
    }

    // 按类别统计成本
    public Map<String, BigDecimal> getCostByCategory(Long experimentRecordId) {
        List<Object[]> results = costRepo.sumCostByCategoryByExperimentRecordId(experimentRecordId);
        return results.stream().collect(
                Collectors.toMap(
                        result -> (String) result[0],
                        result -> (BigDecimal) result[1]
                )
        );
    }

    // 更新成本项
    public ExperimentCost updateCostItem(Long id, ExperimentCost updatedCost) {
        return costRepo.findById(id)
                .map(cost -> {
                    cost.setItemName(updatedCost.getItemName());
                    cost.setCostCategory(updatedCost.getCostCategory());
                    cost.setUnitPrice(updatedCost.getUnitPrice());
                    cost.setQuantity(updatedCost.getQuantity());
                    cost.setCurrency(updatedCost.getCurrency());
                    cost.calculateTotalCost();
                    return costRepo.save(cost);
                })
                .orElseThrow(() -> new RuntimeException("Cost item not found"));
    }

    // 删除成本项
    public void deleteCostItem(Long id) {
        costRepo.deleteById(id);
    }

    // 估算实验成本（基于标准配方）
    public BigDecimal estimateExperimentCost(Long experimentDesignId, Map<String, BigDecimal> reagentQuantities) {
        // 这里可以基于化学品库存中的价格和所需数量来估算成本
        // 实际应用中，需要更复杂的成本计算逻辑
        return BigDecimal.ZERO; // 简化实现
    }
}
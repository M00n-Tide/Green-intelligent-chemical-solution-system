package com.lumap.controller;

import com.lumap.entity.RiskAnalyzer;
import com.lumap.entity.RiskMonitor;
import com.lumap.repository.RiskAnalyzerRepository;
import com.lumap.repository.RiskMonitorRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/risk")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RiskMonitorController {
    private final RiskAnalyzerRepository analyzerRepo;
    private final RiskMonitorRepository monitorRepo;

    public RiskMonitorController(RiskAnalyzerRepository analyzerRepo, RiskMonitorRepository monitorRepo) {
        this.analyzerRepo = analyzerRepo;
        this.monitorRepo = monitorRepo;
    }

    // 获取所有风险分析
    @GetMapping("/analyzers")
    public List<RiskAnalyzer> getAllAnalyzers() {
        return analyzerRepo.findAll();
    }

    // 根据化学品ID获取风险分析
    @GetMapping("/analyzers/chem/{chemId}")
    public List<RiskAnalyzer> getAnalyzersByChemId(@PathVariable Long chemId) {
        return analyzerRepo.findByChemId(chemId);
    }

    // 创建风险分析
    @PostMapping("/analyzers")
    public RiskAnalyzer analyze(@RequestBody RiskAnalyzer analyzer) {
        analyzer.setAnalysisTime(LocalDateTime.now());
        return analyzerRepo.save(analyzer);
    }

    // 获取所有风险监控
    @GetMapping("/monitors")
    public List<RiskMonitor> getAllMonitors() {
        return monitorRepo.findAll();
    }

    // 获取活动中的监控
    @GetMapping("/monitors/active")
    public List<RiskMonitor> getActive() {
        return monitorRepo.findByMonitorStatus(RiskMonitor.MonitorStatus.运行中);
    }

    // 开始监控
    @PostMapping("/monitors/start")
    public RiskMonitor startMonitor(@RequestParam Long analyzerId, @RequestParam String threshold) {
        RiskMonitor monitor = new RiskMonitor();
        monitor.setAnalyzerId(analyzerId);
        monitor.setMonitorStatus(RiskMonitor.MonitorStatus.运行中);
        monitor.setLastCheckTime(LocalDateTime.now());
        monitor.setThreshold(threshold);
        return monitorRepo.save(monitor);
    }

    // 更新监控状态
    @PutMapping("/monitors/{id}/status")
    public RiskMonitor updateMonitorStatus(@PathVariable Long id, @RequestParam RiskMonitor.MonitorStatus status) {
        return monitorRepo.findById(id).map(monitor -> {
            monitor.setMonitorStatus(status);
            return monitorRepo.save(monitor);
        }).orElseThrow(() -> new RuntimeException("Monitor not found"));
    }
}
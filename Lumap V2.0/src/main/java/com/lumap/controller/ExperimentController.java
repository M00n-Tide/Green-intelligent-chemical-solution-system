package com.lumap.controller;

import com.lumap.entity.ExperimentDesign;
import com.lumap.entity.ExperimentRecord;
import com.lumap.repository.ExperimentDesignRepository;
import com.lumap.repository.ExperimentRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/experiments")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExperimentController {
    private final ExperimentDesignRepository designRepo;
    private final ExperimentRecordRepository recordRepo;

    public ExperimentController(ExperimentDesignRepository designRepo, ExperimentRecordRepository recordRepo) {
        this.designRepo = designRepo;
        this.recordRepo = recordRepo;
    }

    // 获取所有实验设计
    @GetMapping("/designs")
    public List<ExperimentDesign> getAllDesigns() {
        return designRepo.findAll();
    }

    // 根据ID获取实验设计
    @GetMapping("/designs/{id}")
    public ExperimentDesign getDesignById(@PathVariable Long id) {
        return designRepo.findById(id).orElseThrow(() -> new RuntimeException("Design not found"));
    }

    // 创建实验设计
    @PostMapping("/designs")
    public ExperimentDesign createDesign(@RequestBody ExperimentDesign design) {
        design.setCreatedDate(LocalDateTime.now());
        design.setStatus(ExperimentDesign.Status.草稿);
        return designRepo.save(design);
    }

    // 更新实验设计状态
    @PutMapping("/designs/{id}/status")
    public ExperimentDesign updateStatus(@PathVariable Long id, @RequestParam ExperimentDesign.Status status) {
        return designRepo.findById(id).map(design -> {
            design.setStatus(status);
            return designRepo.save(design);
        }).orElseThrow(() -> new RuntimeException("Design not found"));
    }

    // 获取所有实验记录
    @GetMapping("/records")
    public List<ExperimentRecord> getAllRecords() {
        return recordRepo.findAll();
    }

    // 根据设计ID获取实验记录
    @GetMapping("/records/design/{designId}")
    public List<ExperimentRecord> getRecordsByDesignId(@PathVariable Long designId) {
        return recordRepo.findByDesignId(designId);
    }

    // 执行实验并记录
    @PostMapping("/records")
    public ExperimentRecord execute(@RequestBody ExperimentRecord record) {
        record.setExecTime(LocalDateTime.now());
        return recordRepo.save(record);
    }
}
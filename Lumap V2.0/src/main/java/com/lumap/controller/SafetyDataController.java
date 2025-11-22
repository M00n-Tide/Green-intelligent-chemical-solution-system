package com.lumap.controller;

import com.lumap.entity.SafetyDatasheet;
import com.lumap.repository.SafetyDatasheetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/safety-datasheets")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SafetyDataController {
    private final SafetyDatasheetRepository repo;

    public SafetyDataController(SafetyDatasheetRepository repo) {
        this.repo = repo;
    }

    // 获取所有安全数据表
    @GetMapping
    public List<SafetyDatasheet> getAll() {
        return repo.findAll();
    }

    // 根据化学品ID获取安全数据表
    @GetMapping("/chem/{chemId}")
    public List<SafetyDatasheet> getByChemId(@PathVariable Long chemId) {
        return repo.findByChemId(chemId);
    }

    // 上传安全数据表
    @PostMapping
    public SafetyDatasheet upload(@RequestBody SafetyDatasheet datasheet, @RequestParam String creator) {
        datasheet.setCreatedBy(creator);
        datasheet.setCreatedTime(new Date());
        datasheet.setStatus(SafetyDatasheet.Status.草稿);
        return repo.save(datasheet);
    }

    // 更新状态
    @PutMapping("/{id}/status")
    public SafetyDatasheet updateStatus(@PathVariable Long id, @RequestParam SafetyDatasheet.Status status) {
        return repo.findById(id).map(ds -> {
            ds.setStatus(status);
            return repo.save(ds);
        }).orElseThrow(() -> new RuntimeException("Datasheet not found"));
    }
}
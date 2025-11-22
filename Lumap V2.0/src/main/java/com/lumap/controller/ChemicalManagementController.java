package com.lumap.controller;

import com.lumap.entity.ChemCatalog;
import com.lumap.entity.ChemInventory;
import com.lumap.service.ChemicalManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chemicals")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChemicalManagementController {
    private final ChemicalManagementService service;

    public ChemicalManagementController(ChemicalManagementService service) {
        this.service = service;
    }

    // 获取所有化学品目录
    @GetMapping("/catalogs")
    public List<ChemCatalog> getAllCatalogs() {
        return service.getAllCatalogs();
    }

    // 根据ID获取化学品目录
    @GetMapping("/catalogs/{id}")
    public ChemCatalog getCatalogById(@PathVariable Long id) {
        return service.getCatalogById(id).orElseThrow(() -> new RuntimeException("Catalog not found"));
    }

    // 创建化学品目录
    @PostMapping("/catalogs")
    public ChemCatalog createCatalog(@RequestBody ChemCatalog catalog) {
        return service.createCatalog(catalog);
    }

    // 更新化学品目录
    @PutMapping("/catalogs/{id}")
    public ChemCatalog updateCatalog(@PathVariable Long id, @RequestBody ChemCatalog catalog) {
        return service.updateCatalog(id, catalog).orElseThrow(() -> new RuntimeException("Catalog not found"));
    }

    // 获取指定化学品的库存信息
    @GetMapping("/inventories")
    public List<ChemInventory> getInventories(@RequestParam(required = false) Long catalogId) {
        if (catalogId != null) {
            return service.getInventoryByCatalogId(catalogId);
        }
        return service.getAllInventory();
    }

    // 添加库存
    @PostMapping("/inventories")
    public ChemInventory addInventory(@RequestBody ChemInventory inventory) {
        return service.addInventory(inventory);
    }

    // 减少库存
    @PutMapping("/inventories/{id}/reduce")
    public ChemInventory reduceInventory(@PathVariable Long id, @RequestParam Double amount) {
        return service.reduceInventory(id, amount).orElseThrow(() -> new RuntimeException("Inventory not found"));
    }
}
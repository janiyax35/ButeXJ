package com.bytex.controller;

import com.bytex.model.Part;
import com.bytex.model.PartRequest;
import com.bytex.service.ProductManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-manager")
public class ProductManagerController {

    @Autowired
    private ProductManagerService productManagerService;

    // Create part replacement request
    @PostMapping("/part-requests")
    public PartRequest createPartRequest(@RequestBody PartRequest partRequest) {
        return productManagerService.createPartRequest(partRequest);
    }

    // Check part availability in stock
    @GetMapping("/parts/{partId}")
    public Part getPartById(@PathVariable Long partId) {
        return productManagerService.getPartById(partId);
    }

    // Update part stock status
    @PutMapping("/parts/{partId}/stock")
    public Part updatePartStock(@PathVariable Long partId, @RequestBody int stock) {
        return productManagerService.updatePartStock(partId, stock);
    }

    // Remove discontinued parts
    @DeleteMapping("/parts/{partId}")
    public void deletePart(@PathVariable Long partId) {
        productManagerService.deletePart(partId);
    }
}

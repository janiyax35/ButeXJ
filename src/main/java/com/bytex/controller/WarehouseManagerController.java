package com.bytex.controller;

import com.bytex.model.PartRequest;
import com.bytex.model.PurchaseOrder;
import com.bytex.service.WarehouseManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-manager")
public class WarehouseManagerController {

    @Autowired
    private WarehouseManagerService warehouseManagerService;

    // Create purchase order for parts
    @PostMapping("/purchase-orders")
    public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return warehouseManagerService.createPurchaseOrder(purchaseOrder);
    }

    // View pending part requests
    @GetMapping("/part-requests")
    public List<PartRequest> getPendingPartRequests() {
        return warehouseManagerService.getPendingPartRequests();
    }

    // Update order status
    @PutMapping("/purchase-orders/{orderId}/status")
    public PurchaseOrder updatePurchaseOrderStatus(@PathVariable Long orderId, @RequestBody String status) {
        return warehouseManagerService.updatePurchaseOrderStatus(orderId, status);
    }

    // Remove completed orders
    @DeleteMapping("/purchase-orders/{orderId}")
    public void deletePurchaseOrder(@PathVariable Long orderId) {
        warehouseManagerService.deletePurchaseOrder(orderId);
    }
}

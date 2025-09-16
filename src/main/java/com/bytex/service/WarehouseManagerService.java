package com.bytex.service;

import com.bytex.model.PartRequest;
import com.bytex.model.PurchaseOrder;
import com.bytex.repository.PartRequestRepository;
import com.bytex.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseManagerService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PartRequestRepository partRequestRepository;

    // Create purchase order for parts
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    // View pending part requests
    public List<PartRequest> getPendingPartRequests() {
        return partRequestRepository.findByStatus("Pending");
    }

    // Update order status
    public PurchaseOrder updatePurchaseOrderStatus(Long orderId, String status) {
        PurchaseOrder order = purchaseOrderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return purchaseOrderRepository.save(order);
        }
        return null;
    }

    // Remove completed orders
    public void deletePurchaseOrder(Long orderId) {
        purchaseOrderRepository.deleteById(orderId);
    }
}

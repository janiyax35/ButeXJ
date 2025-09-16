package com.bytex.controller;

import com.bytex.model.Repair;
import com.bytex.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technician")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    // Create repair record
    @PostMapping("/repairs")
    public Repair createRepair(@RequestBody Repair repair) {
        return technicianService.createRepair(repair);
    }

    // View assigned technical tickets
    @GetMapping("/repairs/{technicianId}")
    public List<Repair> getAssignedRepairs(@PathVariable Long technicianId) {
        return technicianService.getAssignedRepairs(technicianId);
    }

    // Update repair status
    @PutMapping("/repairs/{repairId}/status")
    public Repair updateRepairStatus(@PathVariable Long repairId, @RequestBody String status) {
        return technicianService.updateRepairStatus(repairId, status);
    }

    // Remove completed repair records from my queue
    @DeleteMapping("/repairs/{repairId}")
    public void deleteRepair(@PathVariable Long repairId) {
        technicianService.deleteRepair(repairId);
    }
}

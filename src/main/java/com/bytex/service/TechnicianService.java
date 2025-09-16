package com.bytex.service;

import com.bytex.model.Repair;
import com.bytex.repository.RepairRepository;
import com.bytex.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // Create repair record
    public Repair createRepair(Repair repair) {
        return repairRepository.save(repair);
    }

    // View assigned technical tickets
    public List<Repair> getAssignedRepairs(Long technicianId) {
        return repairRepository.findByTechnicianId(technicianId);
    }

    // Update repair status
    public Repair updateRepairStatus(Long repairId, String status) {
        Repair repair = repairRepository.findById(repairId).orElse(null);
        if (repair != null) {
            repair.setStatus(status);
            return repairRepository.save(repair);
        }
        return null;
    }

    // Remove completed repair records from my queue
    public void deleteRepair(Long repairId) {
        repairRepository.deleteById(repairId);
    }
}

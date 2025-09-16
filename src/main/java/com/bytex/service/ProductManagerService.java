package com.bytex.service;

import com.bytex.model.Part;
import com.bytex.model.PartRequest;
import com.bytex.repository.PartRepository;
import com.bytex.repository.PartRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerService {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private PartRequestRepository partRequestRepository;

    // Create part replacement request
    public PartRequest createPartRequest(PartRequest partRequest) {
        return partRequestRepository.save(partRequest);
    }

    // Check part availability in stock
    public Part getPartById(Long partId) {
        return partRepository.findById(partId).orElse(null);
    }

    // Update part stock status
    public Part updatePartStock(Long partId, int stock) {
        Part part = partRepository.findById(partId).orElse(null);
        if (part != null) {
            part.setStock(stock);
            return partRepository.save(part);
        }
        return null;
    }

    // Remove discontinued parts
    public void deletePart(Long partId) {
        partRepository.deleteById(partId);
    }
}

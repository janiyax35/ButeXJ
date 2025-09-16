package com.bytex.repository;

import com.bytex.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytex.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> findByTechnicianId(Long technicianId);
}

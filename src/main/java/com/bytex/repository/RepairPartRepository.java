package com.bytex.repository;

import com.bytex.model.RepairPart;
import com.bytex.model.RepairPartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairPartRepository extends JpaRepository<RepairPart, RepairPartId> {
}

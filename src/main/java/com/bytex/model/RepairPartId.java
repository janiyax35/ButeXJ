package com.bytex.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RepairPartId implements Serializable {

    private Long repairId;
    private Long partId;

    // Getters, Setters, hashCode, equals
    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepairPartId that = (RepairPartId) o;
        return Objects.equals(repairId, that.repairId) &&
               Objects.equals(partId, that.partId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repairId, partId);
    }
}

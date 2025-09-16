package com.bytex.model;

import javax.persistence.*;

@Entity
@Table(name = "repair_parts")
public class RepairPart {

    @EmbeddedId
    private RepairPartId id;

    @ManyToOne
    @MapsId("repairId")
    @JoinColumn(name = "repair_id")
    private Repair repair;

    @ManyToOne
    @MapsId("partId")
    @JoinColumn(name = "part_id")
    private Part part;

    @Column(nullable = false)
    private int quantity;

    // Getters and Setters
    public RepairPartId getId() {
        return id;
    }

    public void setId(RepairPartId id) {
        this.id = id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

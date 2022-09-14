package com.autosystem.warehouse.shipping.model;

import com.autosystem.common.Views;
import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "availability")
    @JsonView(Views.Public.class)
    public Boolean availability;

    @Column(name = "available_quantity")
    @JsonView(Views.Public.class)
    public int availableQuantity;

    @Column(name = "preparation_time_days")
    @JsonView(Views.Public.class)
    public int preparationTimeDays;

    @OneToOne()
    @JoinColumn(name = "warehouse_stock_id", referencedColumnName = "id")
    WarehouseStock warehouseStock;

    public Shipping() {
    }

    public Shipping(Boolean availability, int availableQuantity, int preparationTimeDays, WarehouseStock warehouseStock) {
        this.availability = availability;
        this.availableQuantity = availableQuantity;
        this.preparationTimeDays = preparationTimeDays;
        this.warehouseStock = warehouseStock;
    }
}

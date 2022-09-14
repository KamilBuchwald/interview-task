package com.autosystem.warehouse.warehousestock.model;

import com.autosystem.common.Views;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.autosystem.warehouse.shipping.model.Shipping;
import com.autosystem.warehouse.warehouse.model.Warehouse;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "warehouse_stock")
public class WarehouseStock {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @OneToOne()
    @JoinColumn(name = "vehicle_part_id", referencedColumnName = "id")
    @JsonView(Views.Public.class)
    public VehiclePart vehiclePart;

    @ManyToOne()
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    @JsonView(Views.Public.class)
    public Warehouse warehouse;

    @OneToOne()
    @JoinColumn(name = "warehouse_stock_id", referencedColumnName = "id")
    @JsonView(Views.Public.class)
    public Shipping shipping;

    public WarehouseStock() {
    }

    public WarehouseStock(VehiclePart vehiclePart, Warehouse warehouse) {
        this.vehiclePart = vehiclePart;
        this.warehouse = warehouse;
    }
}

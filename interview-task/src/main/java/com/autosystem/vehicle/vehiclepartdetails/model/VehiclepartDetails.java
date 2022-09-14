package com.autosystem.vehicle.vehiclepartdetails.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.autosystem.common.Views;
import org.hibernate.annotations.Type;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "vehicle_part_details")
public class VehiclepartDetails {

    @Id
    @Column(name = "id")
    @JsonView(Views.Internal.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "producer")
    @JsonView(Views.Public.class)
    public String producer;

    @Column(name = "price")
    @JsonView(Views.Public.class)
    public String price;

    @OneToOne()
    @JsonView(Views.Internal.class)
    @JoinColumn(name = "vehicle_part_id")
    VehiclePart vehiclePart;

    public VehiclepartDetails() {
    }

    public VehiclepartDetails(String producer, String price, VehiclePart vehiclePart) {
        this.producer = producer;
        this.price = price;
        this.vehiclePart = vehiclePart;
    }
}

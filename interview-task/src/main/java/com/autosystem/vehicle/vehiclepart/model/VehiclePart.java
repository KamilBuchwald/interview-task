package com.autosystem.vehicle.vehiclepart.model;

import com.autosystem.vehicle.vehicle.model.Vehicle;
import com.autosystem.vehicle.vehiclepartdetails.model.VehiclepartDetails;
import com.fasterxml.jackson.annotation.JsonView;
import com.autosystem.common.Views;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vehicle_part")
public class VehiclePart {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "name")
    @JsonView(Views.Public.class)
    public String name;

    @Column(name = "description")
    @JsonView(Views.Public.class)
    public String description;

    @OneToOne()
    @JoinColumn(name = "vehicle_part_details_id", referencedColumnName = "id")
    @JsonView(Views.Public.class)
    public VehiclepartDetails vehiclePartDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @JsonView(Views.Public.class)
    public Vehicle vehicle;

    public VehiclePart(String name, String description, Vehicle vehicle) {
        this.name = name;
        this.description = description;
        this.vehicle = vehicle;
    }

    public VehiclePart() {
    }
}

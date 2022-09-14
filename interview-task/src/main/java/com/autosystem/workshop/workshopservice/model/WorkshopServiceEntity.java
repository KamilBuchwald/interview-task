package com.autosystem.workshop.workshopservice.model;

import com.autosystem.common.Views;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.autosystem.workshop.workshop.model.Workshop;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "workshop_service")
public class WorkshopServiceEntity {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @OneToOne()
    @JoinColumn(name = "vehicle_part_id", referencedColumnName = "id")
    @JsonView(Views.Public.class)
    public VehiclePart vehiclePart;

    @Column(name = "avaialbe_service_date_start")
    @JsonView(Views.Public.class)
    public Instant availableServiceDateStart;

    @Column(name = "avaialbe_service_date_end")
    @JsonView(Views.Public.class)
    public Instant availableServiceDateEnd;

    @OneToOne()
    @JoinColumn(name = "workshop_id", referencedColumnName = "id")
    @JsonView(Views.Public.class)
    public Workshop workshop;

    public WorkshopServiceEntity(){}

    public WorkshopServiceEntity(VehiclePart vehiclePart, Instant availableServiceDateStart, Instant availableServiceDateEnd, Workshop workshop){
        this.vehiclePart = vehiclePart;
        this.availableServiceDateStart = availableServiceDateStart;
        this.availableServiceDateEnd = availableServiceDateEnd;
        this.workshop = workshop;
    }
}

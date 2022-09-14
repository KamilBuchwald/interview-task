package com.autosystem.vehicle.vehicle.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.autosystem.common.Views;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "mark")
    @JsonView(Views.Public.class)
    public String mark;

    @Column(name = "model")
    @JsonView(Views.Public.class)
    public String model;

    @Column(name = "production_date_start")
    @JsonView(Views.Public.class)
    public Instant productionDateStart;

    @Column(name = "production_date_end")
    @JsonView(Views.Public.class)
    public Instant productionDateEnd;

    @Column(name = "creation_date")
    @JsonView(Views.Internal.class)
    public Instant creationDate = Instant.now();

    public Vehicle() {
    }

    public Vehicle(String mark, String model, Instant productionDateStart, Instant productionDateEnd) {
        this.mark = mark;
        this.model = model;
        this.productionDateStart = productionDateStart;
        this.productionDateEnd = productionDateEnd;
    }
}

package com.autosystem.workshop.workshopdetails.model;

import com.autosystem.common.Views;
import com.autosystem.workshop.workshop.model.Workshop;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "workshop_details")
public class WorkshopDetails {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "opening_hours")
    @JsonView(Views.Public.class)
    String openingHours;

    @Column(name = "location")
    @JsonView(Views.Public.class)
    String location;

    @OneToOne
    @JoinColumn(name = "workshop_id", referencedColumnName = "id")
    Workshop workshop;

    public WorkshopDetails(){}

    public WorkshopDetails(String openingHours, String location, Workshop workshop){
        this.openingHours = openingHours;
        this.location = location;
        this.workshop = workshop;
    }
}

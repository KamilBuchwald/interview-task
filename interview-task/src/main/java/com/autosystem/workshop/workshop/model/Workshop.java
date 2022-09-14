package com.autosystem.workshop.workshop.model;

import com.autosystem.common.Views;
import com.autosystem.workshop.workshopdetails.model.WorkshopDetails;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "workshop")
public class Workshop {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "name")
    @JsonView(Views.Public.class)
    public String name;

    @OneToOne()
    @JoinColumn(name = "workshop_details_id", referencedColumnName = "id")
    public WorkshopDetails workshopDetails;

    public Workshop() {
    }

    public Workshop(String name) {
        this.name = name;
    }
}

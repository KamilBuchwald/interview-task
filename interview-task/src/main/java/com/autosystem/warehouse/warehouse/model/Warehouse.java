package com.autosystem.warehouse.warehouse.model;

import com.autosystem.common.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "name")
    @JsonView(Views.Public.class)
    public String name;

    @Column(name = "location")
    @JsonView(Views.Public.class)
    public String location;

    public Warehouse() {
    }

    public Warehouse(String name, String location) {
        this.name = name;
        this.location = location;
    }
}

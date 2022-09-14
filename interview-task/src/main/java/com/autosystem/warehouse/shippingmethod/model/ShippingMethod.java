package com.autosystem.warehouse.shippingmethod.model;

import com.autosystem.common.Views;
import com.autosystem.warehouse.warehouse.model.Warehouse;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shipping_method")
public class ShippingMethod {

    @Id
    @Column(name = "id")
    @JsonView(Views.Public.class)
    @Type(type = "pg-uuid")
    public UUID id = UUID.randomUUID();

    @Column(name = "name")
    @JsonView(Views.Public.class)
    public String name;

    @Column(name = "days_of_delivery")
    @JsonView(Views.Public.class)
    public int daysOfDelivery;

    @Column(name = "shipping_method_price")
    @JsonView(Views.Public.class)
    public String shippingMethodPrice;

    @OneToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    public Warehouse warehouse;

    public ShippingMethod() {
    }

    public ShippingMethod(String name, int daysOfDelivery, String shippingMethodPrice, Warehouse warehouse) {
        this.name = name;
        this.daysOfDelivery = daysOfDelivery;
        this.shippingMethodPrice = shippingMethodPrice;
        this.warehouse = warehouse;
    }
}

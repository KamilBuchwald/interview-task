package com.autosystem.warehouse.shippingmethod.control;

import com.autosystem.warehouse.shippingmethod.model.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, UUID> {
}

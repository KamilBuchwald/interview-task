package com.autosystem.warehouse.shipping.control;

import com.autosystem.warehouse.shipping.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShippingRepository extends JpaRepository<Shipping, UUID> {
}

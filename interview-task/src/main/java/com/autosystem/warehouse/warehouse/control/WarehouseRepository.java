package com.autosystem.warehouse.warehouse.control;

import com.autosystem.warehouse.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {
}

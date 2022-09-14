package com.autosystem.warehouse.warehousestock.control;

import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface WarehouseStockRepository extends JpaRepository<WarehouseStock, UUID> {

    ArrayList<WarehouseStock> findAllByVehiclePart_Id(UUID vehiclePartId);

}

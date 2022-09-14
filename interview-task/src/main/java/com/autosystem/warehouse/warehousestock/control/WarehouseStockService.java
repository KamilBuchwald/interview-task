package com.autosystem.warehouse.warehousestock.control;

import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class WarehouseStockService {

    private WarehouseStockRepository warehouseStockRepository;

    public WarehouseStockService(WarehouseStockRepository warehouseStockRepository) {
        this.warehouseStockRepository = warehouseStockRepository;
    }

    public ArrayList<WarehouseStock> getVehiclePartAvailabilityInfo(UUID vehiclePartId) {
        return this.warehouseStockRepository.findAllByVehiclePart_Id(vehiclePartId);
    }
}

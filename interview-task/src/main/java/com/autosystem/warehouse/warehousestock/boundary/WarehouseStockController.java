package com.autosystem.warehouse.warehousestock.boundary;

import com.autosystem.common.Views;
import com.autosystem.warehouse.warehousestock.control.WarehouseStockService;
import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dealer/warehouse/")
public class WarehouseStockController {

    private WarehouseStockService warehouseStockService;

    public WarehouseStockController(WarehouseStockService warehouseStockService) {
        this.warehouseStockService = warehouseStockService;
    }

    @GetMapping("/{vehiclePartId}")
    @JsonView(Views.Public.class)
    @ApiOperation(value = "Vehicle part availability in warehouse",
            notes = "Get list with info contains availability of given part.")
    public ResponseEntity<List<WarehouseStock>> getVehiclePartAvailability(@PathVariable String vehiclePartId) {
        return ResponseEntity.ok(warehouseStockService.getVehiclePartAvailabilityInfo(UUID.fromString(vehiclePartId)));
    }
}

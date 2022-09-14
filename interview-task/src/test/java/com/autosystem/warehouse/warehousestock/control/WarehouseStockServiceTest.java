package com.autosystem.warehouse.warehousestock.control;

import com.autosystem.stub.WarehouseStockRepositoryStub;
import com.autosystem.vehicle.vehicle.model.Vehicle;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.autosystem.warehouse.warehouse.model.Warehouse;
import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;


class WarehouseStockServiceTest {

    private static WarehouseStockRepositoryStub warehouseStockRepositoryStub;

    private static WarehouseStockService warehouseStockService;

    private static VehiclePart sampleVehiclePart;

    private static Vehicle sampleVehicle;

    @BeforeAll
    static void setUp() {
        warehouseStockRepositoryStub = new WarehouseStockRepositoryStub();
        sampleVehicle = new Vehicle("SampleMark", "SampleModel", Instant.now(), Instant.now());
        sampleVehiclePart = new VehiclePart("SampleVehiclePart", "SampleVehiclePartDescription", sampleVehicle);
        Warehouse sampleWarehouse = new Warehouse("SampleWarehouse", "SampleWarehouseLocation");
        warehouseStockService = new WarehouseStockService(warehouseStockRepositoryStub);
        warehouseStockRepositoryStub.save(new WarehouseStock(sampleVehiclePart, sampleWarehouse));
    }

    @Test
    void getVehiclePartAvailabilityInfo() {
        //given
        UUID vehiclePartId = sampleVehiclePart.id;

        //when
        ArrayList<WarehouseStock> vehiclePart = warehouseStockService.getVehiclePartAvailabilityInfo(vehiclePartId);

        //then
        Assertions.assertEquals(vehiclePart.size(), 1);
    }

    @Test
    void cannotGetVehiclePartAvailabilityInfoByWrongId() {
        //given
        UUID vehiclePartId = UUID.randomUUID();

        //when
        ArrayList<WarehouseStock> vehiclePart = warehouseStockService.getVehiclePartAvailabilityInfo(vehiclePartId);

        //then
        Assertions.assertEquals(vehiclePart.size(), 0);
    }
}

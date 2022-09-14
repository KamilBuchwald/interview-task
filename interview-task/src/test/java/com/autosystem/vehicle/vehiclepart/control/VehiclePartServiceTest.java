package com.autosystem.vehicle.vehiclepart.control;

import com.autosystem.common.exception.EntityNotFoundException;
import com.autosystem.stub.VehiclePartRepositoryStub;
import com.autosystem.vehicle.vehicle.model.Vehicle;
import com.autosystem.vehicle.vehiclepart.dto.UpdateVehiclePartDto;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

class VehiclePartServiceTest {

    private static VehiclePartRepositoryStub vehiclePartRepositoryStub;

    private static VehiclePartService vehiclePartService;

    private static VehiclePart sampleVehiclePart;

    private static Vehicle sampleVehicle;

    @BeforeAll
    static void setUp() {
        vehiclePartRepositoryStub = new VehiclePartRepositoryStub();
        sampleVehicle = new Vehicle("SampleMark", "SampleModel", Instant.now(), Instant.now());
        sampleVehiclePart = new VehiclePart("SampleVehiclePart", "SampleVehiclePartDescription", sampleVehicle);
        vehiclePartRepositoryStub.vehicleParts.add(sampleVehiclePart);
        vehiclePartService = new VehiclePartService(vehiclePartRepositoryStub);
    }

    @Test
    void findAllVehicleParts() {
        //given

        //when
        ArrayList<VehiclePart> foundVehicleParts = vehiclePartService.findAllVehicleParts("SampleMark", "SampleModel", "SampleVehiclePart");

        //then
        assert (foundVehicleParts.size() == 1);

    }

    @Test
    void dontFindAllVehicleParts() {
        //given

        //when
        ArrayList<VehiclePart> foundVehicleParts = vehiclePartService.findAllVehicleParts("NotExistingMark", "NotExistingModel", "Description");

        //then
        assert (foundVehicleParts.size() == 0);

    }

    @Test
    void cannotFindVehicleWithSpecificDescriptionOrName() {
        //given

        //when
        ArrayList<VehiclePart> foundVehicleParts = vehiclePartService.findAllVehicleParts("SampleMark", "SampleModel", "NotExistDescriptionOrName");

        //then
        assert (foundVehicleParts.size() == 0);

    }

    @Test
    void updateVehiclePartDescription() {
        //given
        UpdateVehiclePartDto updateVehiclePartDto = new UpdateVehiclePartDto();
        String newDescription = "Updated Vehicle Part Description";
        updateVehiclePartDto.description = newDescription;
        UUID vehiclePartId = sampleVehiclePart.id;

        //when
        VehiclePart updatedVehiclePart = vehiclePartService.updateVehiclePartDescription(vehiclePartId, updateVehiclePartDto);

        //then
        assert (updatedVehiclePart.description.equals(newDescription));
    }

    @Test
    void cannotUpdateVehiclePartDescriptionWithBadVehiclePartId() {
        //given
        UpdateVehiclePartDto updateVehiclePartDto = new UpdateVehiclePartDto();
        String newDescription = "Updated Vehicle Part Description";
        updateVehiclePartDto.description = newDescription;
        UUID vehiclePartId = UUID.randomUUID();

        //when
        Assertions.assertThrows(EntityNotFoundException.class, () ->
                vehiclePartService.updateVehiclePartDescription(vehiclePartId, updateVehiclePartDto));

        //then
    }

    @Test
    void getVehiclePartById() {
        //given
        UUID vehiclePartId = sampleVehiclePart.id;

        //when
        VehiclePart foundVehiclePart = vehiclePartService.getVehiclePartById(vehiclePartId);

        //then
        Assertions.assertNotEquals(foundVehiclePart, null);
    }

    @Test
    void cannotGetVehiclePartById() {
        //given
        UUID vehiclePartId = UUID.randomUUID();

        //when
        Assertions.assertThrows(EntityNotFoundException.class, () ->
                vehiclePartService.getVehiclePartById(vehiclePartId));
    }
}

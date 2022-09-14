package com.autosystem.workshop.workshopservice.control;

import com.autosystem.stub.VehiclePartRepositoryStub;
import com.autosystem.stub.WorkshopRepositoryStub;
import com.autosystem.stub.WorkshopServiceRepositoryStub;
import com.autosystem.vehicle.vehicle.model.Vehicle;
import com.autosystem.vehicle.vehiclepart.control.VehiclePartService;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.autosystem.workshop.workshop.control.WorkshopService;
import com.autosystem.workshop.workshop.model.Workshop;
import com.autosystem.workshop.workshopservice.dto.CreateNewWorkshopServiceDto;
import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

class WorkshopServiceServiceTest {

    private static WorkshopServiceService workshopServiceService;

    private static WorkshopService workshopService;

    private static VehiclePartService vehiclePartService;

    private static VehiclePartRepositoryStub vehiclePartRepositoryStub;


    private static WorkshopServiceRepositoryStub workshopServiceRepositoryStub;

    private static WorkshopRepositoryStub workshopRepositoryStub;

    private static VehiclePart sampleVehiclePart;

    private static Vehicle sampleVehicle;

    private static Workshop sampleWorkshop;

    private static WorkshopServiceEntity sampleWorkshopService;


    @BeforeEach
    void setUp() {
        workshopServiceRepositoryStub = new WorkshopServiceRepositoryStub();
        vehiclePartRepositoryStub = new VehiclePartRepositoryStub();
        workshopRepositoryStub = new WorkshopRepositoryStub();
        vehiclePartService = new VehiclePartService(vehiclePartRepositoryStub);
        sampleVehicle = new Vehicle("SampleMark", "SampleModel", Instant.now(), Instant.now().plus(10, ChronoUnit.DAYS));
        sampleVehiclePart = new VehiclePart("SampleVehiclePart", "SampleVehiclePartDescription", sampleVehicle);
        vehiclePartRepositoryStub.save(sampleVehiclePart);
        sampleWorkshop = new Workshop("SampleWorkshop");
        workshopRepositoryStub.save(sampleWorkshop);
        sampleWorkshopService = new WorkshopServiceEntity(sampleVehiclePart, Instant.now().plus(1, ChronoUnit.DAYS), Instant.now().plus(10, ChronoUnit.DAYS), sampleWorkshop);
        workshopServiceRepositoryStub.save(sampleWorkshopService);
        workshopService = new WorkshopService(workshopRepositoryStub);
        workshopServiceService = new WorkshopServiceService(workshopServiceRepositoryStub, workshopService, vehiclePartService);


    }

    @Test
    void getAllWorkshopServicesForVehicleAndDateRange() {
        //given
        String mark = "SampleMark";
        String model = "SampleModel";
        Instant availableServiceDateStart = Instant.now().plus(2, ChronoUnit.DAYS);
        Instant availableServiceDateEnd = Instant.now().plus(4, ChronoUnit.DAYS);

        //when
        ArrayList<WorkshopServiceEntity> foundWorkshopServices = workshopServiceService.getAllWorkshopServicesForVehicleAndDateRange(
                mark, model, availableServiceDateStart, availableServiceDateEnd
        );

        //then
        Assertions.assertEquals(foundWorkshopServices.size(), 1);
    }

    @Test
    void cannotGetAllWorkshopServicesForVehicleAndDateRangeOutOfRange() {
        //given
        String mark = "SampleMark";
        String model = "SampleModel";
        Instant availableServiceDateStart = Instant.now().plus(2, ChronoUnit.DAYS);
        Instant availableServiceDateEnd = Instant.now().plus(11, ChronoUnit.DAYS);

        //when
        ArrayList<WorkshopServiceEntity> foundWorkshopServices = workshopServiceService.getAllWorkshopServicesForVehicleAndDateRange(
                mark, model, availableServiceDateStart, availableServiceDateEnd
        );

        //then
        Assertions.assertEquals(foundWorkshopServices.size(), 0);
    }

    @Test
    void createNewWorkshopService() {
        //given
        CreateNewWorkshopServiceDto createNewWorkshopServiceDto = new CreateNewWorkshopServiceDto();
        createNewWorkshopServiceDto.partId = sampleVehiclePart.id;
        createNewWorkshopServiceDto.availableServiceDateStart = Instant.now().getEpochSecond();
        createNewWorkshopServiceDto.availableServiceDateEnd = Instant.now().plus(4, ChronoUnit.DAYS).getEpochSecond();


        //when
        WorkshopServiceEntity createdWorkshopService = workshopServiceService.createNewWorkshopService(createNewWorkshopServiceDto);

        //then
        Assertions.assertEquals(createdWorkshopService.vehiclePart.id, sampleVehiclePart.id);
        Assertions.assertEquals(createdWorkshopService.availableServiceDateStart, Instant.ofEpochSecond(createNewWorkshopServiceDto.availableServiceDateStart));
        Assertions.assertEquals(createdWorkshopService.availableServiceDateEnd, Instant.ofEpochSecond(createNewWorkshopServiceDto.availableServiceDateEnd));
    }
}

package com.autosystem.workshop.workshopservice.control;

import com.autosystem.vehicle.vehiclepart.control.VehiclePartService;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.autosystem.workshop.workshop.control.WorkshopService;
import com.autosystem.workshop.workshop.model.Workshop;
import com.autosystem.workshop.workshopservice.dto.CreateNewWorkshopServiceDto;
import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;

@Service
public class WorkshopServiceService {

    private WorkshopServiceRepository workshopServiceRepository;
    private WorkshopService workshopService;

    private VehiclePartService vehiclePartService;

    public WorkshopServiceService(WorkshopServiceRepository workshopServiceRepository, WorkshopService workshopService, VehiclePartService vehiclePartService) {
        this.workshopServiceRepository = workshopServiceRepository;
        this.workshopService = workshopService;
        this.vehiclePartService = vehiclePartService;
    }

    public ArrayList<WorkshopServiceEntity> getAllWorkshopServicesForVehicleAndDateRange(String mark, String model, Instant availableServiceDateStart, Instant availableServiceDateEnd) {
        return workshopServiceRepository.findAllByVehiclePart_Vehicle_MarkAndVehiclePart_Vehicle_ModelAndAvailableServiceDateEndGreaterThanEqualAndAvailableServiceDateStartLessThanEqual(
                mark, model, availableServiceDateEnd, availableServiceDateStart);
    }

    public WorkshopServiceEntity createNewWorkshopService(CreateNewWorkshopServiceDto createNewWorkshopServiceDto) {
        Workshop workshop = this.workshopService.getDefaultWorkshop();
        VehiclePart vehiclePart = this.vehiclePartService.getVehiclePartById(createNewWorkshopServiceDto.partId);
        return workshopServiceRepository.save(new WorkshopServiceEntity(vehiclePart, Instant.ofEpochSecond(createNewWorkshopServiceDto.availableServiceDateStart), Instant.ofEpochSecond(createNewWorkshopServiceDto.availableServiceDateEnd), workshop));
    }
}

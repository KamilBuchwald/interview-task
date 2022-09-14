package com.autosystem.vehicle.vehiclepart.control;

import com.autosystem.common.exception.EntityNotFoundException;
import com.autosystem.vehicle.vehiclepart.dto.UpdateVehiclePartDto;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class VehiclePartService {

    private VehiclePartRepository vehiclePartRepository;

    public VehiclePartService(VehiclePartRepository vehiclePartRepository) {
        this.vehiclePartRepository = vehiclePartRepository;
    }

    public ArrayList<VehiclePart> findAllVehicleParts(String mark, String model, String part) {
        ArrayList<VehiclePart> foundMatchingVehiclePartsByMarkAndModel = vehiclePartRepository.findAllByVehicleMarkAndVehicleModel(mark, model);
        ArrayList<VehiclePart> matchingVehicleParts = new ArrayList<>();
        foundMatchingVehiclePartsByMarkAndModel.forEach(vehiclePart -> {
            if (vehiclePart.name.contains(part) || vehiclePart.description.contains(part)) {
                matchingVehicleParts.add(vehiclePart);
            }
        });
        return matchingVehicleParts;
    }

    public VehiclePart updateVehiclePartDescription(UUID vehiclePartId, UpdateVehiclePartDto updateVehiclePartDto) {
        VehiclePart foundVehiclePart = vehiclePartRepository.findById(vehiclePartId).orElseThrow(
                () -> new EntityNotFoundException(vehiclePartId));
        foundVehiclePart.description = updateVehiclePartDto.description;
        return vehiclePartRepository.save(foundVehiclePart);
    }

    public VehiclePart getVehiclePartById(UUID vehiclePartId) {
        return vehiclePartRepository.findById(vehiclePartId).orElseThrow(() -> new EntityNotFoundException(vehiclePartId));
    }
}

package com.autosystem.vehicle.vehiclepart.control;

import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface VehiclePartRepository extends JpaRepository<VehiclePart, UUID> {
    ArrayList<VehiclePart> findAllByVehicleMarkAndVehicleModel(String mark, String model);
}

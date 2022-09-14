package com.autosystem.vehicle.vehiclepartdetails.control;

import com.autosystem.vehicle.vehiclepartdetails.model.VehiclepartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehiclePartDetailsRepository extends JpaRepository<VehiclepartDetails, UUID> {
}

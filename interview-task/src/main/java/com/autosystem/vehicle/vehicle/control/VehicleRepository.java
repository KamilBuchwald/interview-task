package com.autosystem.vehicle.vehicle.control;

import com.autosystem.vehicle.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}

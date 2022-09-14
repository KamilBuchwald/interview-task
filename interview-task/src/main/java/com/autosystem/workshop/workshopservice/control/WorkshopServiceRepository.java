package com.autosystem.workshop.workshopservice.control;

import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface WorkshopServiceRepository extends JpaRepository<WorkshopServiceEntity, UUID> {
    ArrayList<WorkshopServiceEntity> findAllByVehiclePart_Vehicle_MarkAndVehiclePart_Vehicle_ModelAndAvailableServiceDateEndGreaterThanEqualAndAvailableServiceDateStartLessThanEqual(String mark, String model, Instant availableServiceDateEnd, Instant availableServiceDateStart);
}

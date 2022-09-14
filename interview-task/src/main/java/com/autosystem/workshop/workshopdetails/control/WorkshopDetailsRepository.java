package com.autosystem.workshop.workshopdetails.control;

import com.autosystem.workshop.workshopdetails.model.WorkshopDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkshopDetailsRepository extends JpaRepository<WorkshopDetails, UUID> {
}

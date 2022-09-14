package com.autosystem.workshop.workshop.control;

import com.autosystem.workshop.workshop.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, UUID> {
}

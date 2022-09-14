package com.autosystem.workshop.workshop.control;

import com.autosystem.workshop.workshop.model.Workshop;
import org.springframework.stereotype.Service;

@Service
public class WorkshopService {

    private WorkshopRepository workshopRepository;

    public WorkshopService(WorkshopRepository workshopRepository){
        this.workshopRepository = workshopRepository;
    }

    public Workshop getDefaultWorkshop(){
        return this.workshopRepository.findAll().get(0);
    }
}

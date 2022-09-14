package com.autosystem.workshop.workshopservice.boundary;

import com.autosystem.common.Views;
import com.autosystem.workshop.workshopservice.control.WorkshopServiceService;
import com.autosystem.workshop.workshopservice.dto.CreateNewWorkshopServiceDto;
import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Controller
@RequestMapping("/administrator/workshop")
public class WorkshopServiceAdministratorController {

    private WorkshopServiceService workshopServiceService;

    public WorkshopServiceAdministratorController(WorkshopServiceService workshopServiceService) {
        this.workshopServiceService = workshopServiceService;
    }

    @PostMapping()
    @JsonView(Views.Public.class)
    @ApiOperation(value = "Add new workshop service for specific part")
    public ResponseEntity<WorkshopServiceEntity> addNewWorkshopService(@RequestBody CreateNewWorkshopServiceDto createNewWorkshopServiceDto) {
        return ResponseEntity.ok(workshopServiceService.createNewWorkshopService(createNewWorkshopServiceDto));
    }
}

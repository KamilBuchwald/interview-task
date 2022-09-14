package com.autosystem.workshop.workshopservice.boundary;

import com.autosystem.common.Views;
import com.autosystem.workshop.workshopservice.control.WorkshopServiceService;
import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Controller
@RequestMapping("/dealer/workshop")
public class WorkshopServiceDealerController {

    private WorkshopServiceService workshopServiceService;

    public WorkshopServiceDealerController(WorkshopServiceService workshopServiceService) {
        this.workshopServiceService = workshopServiceService;
    }

    @GetMapping("/{mark}/{model}/{serviceAvailabilityStart}/{serviceAvailabilityEnd}")
    @JsonView(Views.Public.class)
    @ApiOperation(value = "List of workshop services available for specific model and mark in given period of time (time is Unix Timestamp format i.e 1663173624)")
    public ResponseEntity<ArrayList<WorkshopServiceEntity>> getVehiclePartAvailability(@PathVariable String mark, @PathVariable String model,
                                                                                       @PathVariable Long serviceAvailabilityStart, @PathVariable Long serviceAvailabilityEnd) {
        return ResponseEntity.ok(workshopServiceService.getAllWorkshopServicesForVehicleAndDateRange(mark, model, Instant.ofEpochSecond(serviceAvailabilityStart), Instant.ofEpochSecond(serviceAvailabilityEnd)));
    }
}

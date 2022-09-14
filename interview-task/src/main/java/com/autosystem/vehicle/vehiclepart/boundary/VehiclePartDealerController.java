package com.autosystem.vehicle.vehiclepart.boundary;


import com.autosystem.common.Views;
import com.autosystem.vehicle.vehiclepart.control.VehiclePartService;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dealer/vehicle-parts/")
@Api("Dealer API for fetching available parts for specific mark and model.")
public class VehiclePartDealerController {

    private VehiclePartService vehiclePartService;

    public VehiclePartDealerController(VehiclePartService vehiclePartService) {
        this.vehiclePartService = vehiclePartService;
    }

    @ApiOperation(value = "List of vehicle parts",
            notes = "Get list of parts for specify mark and model")
    @GetMapping("/{mark}/{model}/{part}")
    @JsonView(Views.Public.class)
    public ResponseEntity<List<VehiclePart>> getVehiclePartsList(@PathVariable String mark, @PathVariable String model, @PathVariable String part) {
        return ResponseEntity.ok(this.vehiclePartService.findAllVehicleParts(mark,model, part));
    }
}

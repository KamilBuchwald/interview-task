package com.autosystem.vehicle.vehiclepart.boundary;


import com.autosystem.common.Views;
import com.autosystem.vehicle.vehiclepart.control.VehiclePartService;
import com.autosystem.vehicle.vehiclepart.dto.UpdateVehiclePartDto;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/administrator/vehicle-parts")
public class VehiclePartAdministratorController {

    private VehiclePartService vehiclePartService;

    public VehiclePartAdministratorController(VehiclePartService vehiclePartService) {
        this.vehiclePartService = vehiclePartService;
    }

    @ApiOperation(value = "Update description of specific vehicle part")
    @PutMapping("/{partId}")
    @JsonView(Views.Public.class)
    public ResponseEntity<VehiclePart> updateVehiclePartData(@PathVariable String partId, @RequestBody UpdateVehiclePartDto updateVehiclePartDto) {
        return ResponseEntity.ok(this.vehiclePartService.updateVehiclePartDescription(UUID.fromString(partId), updateVehiclePartDto));
    }
}

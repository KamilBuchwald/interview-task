package com.autosystem.workshop.workshopservice.dto;

import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import java.util.UUID;

public class CreateNewWorkshopServiceDto {
    public UUID partId;
    @ApiModelProperty(notes = "Service start date", example = "1663173624", required = true)
    public Long availableServiceDateStart;
    @ApiModelProperty(notes = "Service end date", example = "1663173624", required = true)
    public Long availableServiceDateEnd;
}

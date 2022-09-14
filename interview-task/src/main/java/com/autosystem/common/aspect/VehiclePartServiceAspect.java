package com.autosystem.common.aspect;

import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.format;


@Aspect
@Component
public class VehiclePartServiceAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(* com.autosystem.vehicle.vehiclepart.control.VehiclePartService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info(
                format("Method %s executed with %s arguments",
                        joinPoint.getStaticPart().getSignature(),
                        Arrays.toString(joinPoint.getArgs())
                ));
    }

    @Pointcut("execution(* com.autosystem.vehicle.vehiclepart.control.VehiclePartService.*(..)))")
    public void vehiclePartListPointcut() {
    }

    @AfterThrowing(
            pointcut = "vehiclePartListPointcut()",
            throwing = "e"
    )
    public void logExceptions(JoinPoint jp, Exception e) {
        logger.error("Handled Exception: "+ e.getMessage());
    }

    @AfterReturning(value = "execution(* com.autosystem.vehicle.vehiclepart.control.VehiclePartService.findAllVehicleParts(..))", returning = "vehicleParts")
    public void afterReturningAdvice(JoinPoint joinPoint, ArrayList<VehiclePart> vehicleParts) {
        vehicleParts.forEach(vehiclePart -> {
            logger.info(joinPoint.getSignature().getName() + " method returned: " + vehiclePart.name);
        });
    }

    @AfterReturning(value = "execution(* com.autosystem.vehicle.vehiclepart.control.VehiclePartService.getVehiclePartById(..))", returning = "vehiclePart")
    public void afterReturningAdvice(JoinPoint joinPoint, VehiclePart vehiclePart) {
        logger.info(joinPoint.getSignature().getName() + " method returned: "+ vehiclePart);
    }
}

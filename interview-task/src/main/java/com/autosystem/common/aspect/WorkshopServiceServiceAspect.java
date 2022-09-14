package com.autosystem.common.aspect;

import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.format;

@Aspect
@Component
public class WorkshopServiceServiceAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(* com.autosystem.workshop.workshopservice.control.WorkshopServiceService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info(
                format("Method %s executed with %s arguments",
                        joinPoint.getStaticPart().getSignature(),
                        Arrays.toString(joinPoint.getArgs())
                ));
    }

    @AfterReturning(value = "execution(* com.autosystem.workshop.workshopservice.control.WorkshopServiceService.getAllWorkshopServicesForVehicleAndDateRange(..))", returning = "workshopServicesList")
    public void afterReturningAdvice(JoinPoint joinPoint, ArrayList<WorkshopServiceEntity> workshopServicesList) {
        workshopServicesList.forEach(workshopService -> {
            logger.info(joinPoint.getSignature().getName() + " method returned: " + workshopService.id);
        });
    }

    @AfterReturning(value = "execution(* com.autosystem.workshop.workshopservice.control.WorkshopServiceService.createNewWorkshopService())", returning = "createdWorkshopService")
    public void afterReturningAdvice(JoinPoint joinPoint, WorkshopServiceEntity createdWorkshopService) {
        logger.info(joinPoint.getSignature().getName() + " method returned: " + createdWorkshopService.id);
    }
}

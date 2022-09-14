package com.autosystem.common.aspect;

import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
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
public class WarehouseStockServiceAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(* com.autosystem.warehouse.warehousestock.control.WarehouseStockService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info(
                format("Method %s executed with %s arguments",
                        joinPoint.getStaticPart().getSignature(),
                        Arrays.toString(joinPoint.getArgs())
                ));
    }

    @AfterReturning(value = "execution(* com.autosystem.warehouse.warehousestock.control.WarehouseStockService.getVehiclePartAvailabilityInfo(..))", returning = "warehouseStockAvailabilityInfo")
    public void afterReturningAdvice(JoinPoint joinPoint, ArrayList<WarehouseStock> warehouseStockAvailabilityInfo) {
        warehouseStockAvailabilityInfo.forEach(warehouseStock -> {
            logger.info(joinPoint.getSignature().getName() + " method returned: " + warehouseStock.id);
        });
    }
}

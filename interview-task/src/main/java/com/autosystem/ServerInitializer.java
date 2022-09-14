package com.autosystem;

import com.autosystem.vehicle.vehicle.control.VehicleRepository;
import com.autosystem.vehicle.vehicle.model.Vehicle;
import com.autosystem.vehicle.vehiclepart.control.VehiclePartRepository;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import com.autosystem.vehicle.vehiclepartdetails.control.VehiclePartDetailsRepository;
import com.autosystem.vehicle.vehiclepartdetails.model.VehiclepartDetails;
import com.autosystem.warehouse.shipping.control.ShippingRepository;
import com.autosystem.warehouse.shipping.model.Shipping;
import com.autosystem.warehouse.shippingmethod.control.ShippingMethodRepository;
import com.autosystem.warehouse.shippingmethod.model.ShippingMethod;
import com.autosystem.warehouse.warehouse.control.WarehouseRepository;
import com.autosystem.warehouse.warehouse.model.Warehouse;
import com.autosystem.warehouse.warehousestock.control.WarehouseStockRepository;
import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
import com.autosystem.workshop.workshop.control.WorkshopRepository;
import com.autosystem.workshop.workshop.model.Workshop;
import com.autosystem.workshop.workshopdetails.control.WorkshopDetailsRepository;
import com.autosystem.workshop.workshopdetails.model.WorkshopDetails;
import com.autosystem.workshop.workshopservice.control.WorkshopServiceRepository;
import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;


@Component
public class ServerInitializer implements ApplicationRunner {

    private VehicleRepository vehicleRepository;
    private VehiclePartRepository vehiclePartRepository;
    private VehiclePartDetailsRepository vehiclePartDetailsRepository;

    private WarehouseRepository warehouseRepository;

    private WarehouseStockRepository warehouseStockRepository;

    private ShippingMethodRepository shippingMethodRepository;

    private ShippingRepository shippingRepository;

    private WorkshopServiceRepository workshopServiceRepository;

    private WorkshopRepository workshopRepository;

    private WorkshopDetailsRepository workshopDetailsRepository;


    public ServerInitializer(VehicleRepository vehicleRepository, VehiclePartRepository vehiclePartRepository,
                             VehiclePartDetailsRepository vehiclePartDetailsRepository, WarehouseRepository warehouseRepository,
                             WarehouseStockRepository warehouseStockRepository, ShippingMethodRepository shippingMethodRepository,
                             ShippingRepository shippingRepository, WorkshopServiceRepository workshopServiceRepository,
                             WorkshopDetailsRepository workshopDetailsRepository, WorkshopRepository workshopRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehiclePartRepository = vehiclePartRepository;
        this.vehiclePartDetailsRepository = vehiclePartDetailsRepository;
        this.warehouseRepository = warehouseRepository;
        this.warehouseStockRepository = warehouseStockRepository;
        this.shippingMethodRepository = shippingMethodRepository;
        this.shippingRepository = shippingRepository;
        this.workshopServiceRepository = workshopServiceRepository;
        this.workshopDetailsRepository = workshopDetailsRepository;
        this.workshopRepository = workshopRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {

        //Vehicles
        Vehicle volkswagenPassat = new Vehicle("Volkswagen", "Passat", Instant.now(), Instant.now());
        this.vehicleRepository.save(volkswagenPassat);

        Vehicle audiA4 = new Vehicle("Audi", "A4", Instant.now(), Instant.now());
        this.vehicleRepository.save(audiA4);

        Vehicle bmwX5 = new Vehicle("BMW", "X5", Instant.now(), Instant.now());
        this.vehicleRepository.save(bmwX5);

        //VehicleParts
        //Volkswagen
        VehiclePart volkswagenPassatVehiclePart1 = this.vehiclePartRepository.save(new VehiclePart("Filtr hydrauliczny automatycznej skrzyni biegów FEBI BILSTEIN 101900", "Rodzaj filtra: Filtr sitowy", volkswagenPassat));
        VehiclepartDetails volkswagenPassatVehiclePartDetails = this.vehiclePartDetailsRepository.save(new VehiclepartDetails("FEBI BILSTEIN", "117", volkswagenPassatVehiclePart1));
        volkswagenPassatVehiclePart1.vehiclePartDetails = volkswagenPassatVehiclePartDetails;
        this.vehiclePartRepository.save(volkswagenPassatVehiclePart1);

        VehiclePart volkswagenPassatVehiclePart2 = this.vehiclePartRepository.save(new VehiclePart("SONDA LAMBDA FEBI BILSTEIN 17536", "Długość [mm]: 437", volkswagenPassat));
        VehiclepartDetails volkswagenPassatVehicleDetails2 = this.vehiclePartDetailsRepository.save(new VehiclepartDetails("FEBI BILSTEIN", "97", volkswagenPassatVehiclePart2));
        volkswagenPassatVehiclePart2.vehiclePartDetails = volkswagenPassatVehicleDetails2;
        this.vehiclePartRepository.save(volkswagenPassatVehiclePart2);

        //BMW
        VehiclePart bmwX5VehiclePart1 = this.vehiclePartRepository.save(new VehiclePart("SFERA HYDROPNEUMATYCZNA FEBI BILSTEIN 26537", "Rodzaj filtra: Filtr sitowy", bmwX5));
        VehiclepartDetails bmwX5VehiclePartDetails1 = this.vehiclePartDetailsRepository.save(new VehiclepartDetails("FEBI BILSTEIN", "868", bmwX5VehiclePart1));
        bmwX5VehiclePart1.vehiclePartDetails = bmwX5VehiclePartDetails1;
        this.vehiclePartRepository.save(bmwX5VehiclePart1);

        VehiclePart bmwX5VehiclePart2 = this.vehiclePartRepository.save(new VehiclePart("Zacisk hamulca FERODO FCL695100", "typ zacisku hamulca: Zacisk hamulcowy ze zintegrowanym hamulcem pomocniczym", bmwX5));
        VehiclepartDetails bmwX5VehiclePartDetails2 = this.vehiclePartDetailsRepository.save(new VehiclepartDetails("FERODO", "253", bmwX5VehiclePart2));
        bmwX5VehiclePart2.vehiclePartDetails = bmwX5VehiclePartDetails2;
        this.vehiclePartRepository.save(bmwX5VehiclePart2);

        //Audi
        VehiclePart audiA4VehiclePart1 = this.vehiclePartRepository.save(new VehiclePart("Akumulator ciśnienia układu zawieszenia FEBI BILSTEIN 01817", "4027816018179", audiA4));
        VehiclepartDetails audiA4VehiclePart1Details1 = this.vehiclePartDetailsRepository.save(new VehiclepartDetails("FEBI BILSTEIN", "210", audiA4VehiclePart1));
        audiA4VehiclePart1.vehiclePartDetails = audiA4VehiclePart1Details1;
        this.vehiclePartRepository.save(audiA4VehiclePart1);

        VehiclePart audiA4VehiclePart2 = this.vehiclePartRepository.save(new VehiclePart("Klocki hamulcowe FERODO FDB4842", "Oznaczenie kontrolne: R90 Homologated", audiA4));
        VehiclepartDetails audiA4VehiclePart1Details2 = this.vehiclePartDetailsRepository.save(new VehiclepartDetails("Ferodo", "107", audiA4VehiclePart2));
        audiA4VehiclePart2.vehiclePartDetails = audiA4VehiclePart1Details2;
        this.vehiclePartRepository.save(audiA4VehiclePart2);

        //Warehouse
        Warehouse warehouse = this.warehouseRepository.save(new Warehouse("Magazyn Poznan", "Poznan"));
        shippingMethodRepository.save(new ShippingMethod("DHL", 2, "100", warehouse));
        Workshop workshop = this.workshopRepository.save(new Workshop("Warsztat Poznan"));
        WorkshopDetails workshopDetails = this.workshopDetailsRepository.save(new WorkshopDetails("8-18", "Poznan", workshop));
        workshop.workshopDetails = workshopDetails;
        this.workshopRepository.save(workshop);

        //WarehouseStock
        WarehouseStock warehouseStock = warehouseStockRepository.save(new WarehouseStock(volkswagenPassatVehiclePart1, warehouse));
        Shipping shipping = shippingRepository.save(new Shipping(true, 12, 3, warehouseStock));
        warehouseStock.shipping = shipping;
        warehouseStockRepository.save(warehouseStock);

        WarehouseStock warehouseStock2 = warehouseStockRepository.save(new WarehouseStock(volkswagenPassatVehiclePart2, warehouse));
        Shipping shipping2 = shippingRepository.save(new Shipping(true, 4, 1, warehouseStock));
        warehouseStock2.shipping = shipping2;
        warehouseStockRepository.save(warehouseStock2);

        WarehouseStock warehouseStock3 = warehouseStockRepository.save(new WarehouseStock(bmwX5VehiclePart1, warehouse));
        Shipping shipping3 = shippingRepository.save(new Shipping(true, 20, 2, warehouseStock));
        warehouseStock3.shipping = shipping3;
        warehouseStockRepository.save(warehouseStock3);

        WarehouseStock warehouseStock4 = warehouseStockRepository.save(new WarehouseStock(bmwX5VehiclePart2, warehouse));
        Shipping shipping4 = shippingRepository.save(new Shipping(true, 5, 1, warehouseStock));
        warehouseStock4.shipping = shipping4;
        warehouseStockRepository.save(warehouseStock4);

        WarehouseStock warehouseStock5 = warehouseStockRepository.save(new WarehouseStock(audiA4VehiclePart1, warehouse));
        Shipping shipping5 = shippingRepository.save(new Shipping(true, 2, 1, warehouseStock));
        warehouseStock5.shipping = shipping5;
        warehouseStockRepository.save(warehouseStock5);

        WarehouseStock warehouseStock6 = warehouseStockRepository.save(new WarehouseStock(audiA4VehiclePart2, warehouse));
        Shipping shipping6 = shippingRepository.save(new Shipping(true, 7, 3, warehouseStock));
        warehouseStock6.shipping = shipping6;
        warehouseStockRepository.save(warehouseStock6);

        //Workshop - services
        this.workshopServiceRepository.save(new WorkshopServiceEntity(volkswagenPassatVehiclePart1, Instant.now(), Instant.now().plus(10, ChronoUnit.DAYS), workshop));
        this.workshopServiceRepository.save(new WorkshopServiceEntity(volkswagenPassatVehiclePart2, Instant.now(), Instant.now().plus(15, ChronoUnit.DAYS), workshop));
        this.workshopServiceRepository.save(new WorkshopServiceEntity(bmwX5VehiclePart1, Instant.now(), Instant.now().plus(6, ChronoUnit.DAYS), workshop));
        this.workshopServiceRepository.save(new WorkshopServiceEntity(bmwX5VehiclePart2, Instant.now(), Instant.now().plus(12, ChronoUnit.DAYS), workshop));
        this.workshopServiceRepository.save(new WorkshopServiceEntity(audiA4VehiclePart1, Instant.now(), Instant.now().plus(3, ChronoUnit.DAYS), workshop));
        this.workshopServiceRepository.save(new WorkshopServiceEntity(audiA4VehiclePart2, Instant.now(), Instant.now().plus(30, ChronoUnit.DAYS), workshop));
    }
}

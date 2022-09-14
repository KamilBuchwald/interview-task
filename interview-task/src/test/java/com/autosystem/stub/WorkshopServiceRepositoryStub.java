package com.autosystem.stub;

import com.autosystem.workshop.workshopservice.control.WorkshopServiceRepository;
import com.autosystem.workshop.workshopservice.model.WorkshopServiceEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class WorkshopServiceRepositoryStub implements WorkshopServiceRepository {

    ArrayList<WorkshopServiceEntity> workshopServicesList = new ArrayList<>();

    @Override
    public ArrayList<WorkshopServiceEntity> findAllByVehiclePart_Vehicle_MarkAndVehiclePart_Vehicle_ModelAndAvailableServiceDateEndGreaterThanEqualAndAvailableServiceDateStartLessThanEqual(String mark, String model, Instant availableServiceDateEnd, Instant availableServiceDateStart) {
        ArrayList<WorkshopServiceEntity> foundWorkshopServices = new ArrayList<>();
        workshopServicesList.forEach(workshopService -> {
            if (workshopService.vehiclePart.vehicle.mark.equals(mark) && workshopService.vehiclePart.vehicle.model.equals(model) && workshopService.availableServiceDateStart.isBefore(availableServiceDateStart) && workshopService.availableServiceDateEnd.isAfter(availableServiceDateEnd)) {
                foundWorkshopServices.add(workshopService);
            }
        });
        return foundWorkshopServices;
    }

    @Override
    public List<WorkshopServiceEntity> findAll() {
        return null;
    }

    @Override
    public List<WorkshopServiceEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<WorkshopServiceEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<WorkshopServiceEntity> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(WorkshopServiceEntity workshopServiceEntity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends WorkshopServiceEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends WorkshopServiceEntity> S save(S s) {
        workshopServicesList.add(s);
        return s;
    }

    @Override
    public <S extends WorkshopServiceEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<WorkshopServiceEntity> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends WorkshopServiceEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends WorkshopServiceEntity> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<WorkshopServiceEntity> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public WorkshopServiceEntity getOne(UUID uuid) {
        return null;
    }

    @Override
    public WorkshopServiceEntity getById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends WorkshopServiceEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends WorkshopServiceEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends WorkshopServiceEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends WorkshopServiceEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends WorkshopServiceEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends WorkshopServiceEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends WorkshopServiceEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

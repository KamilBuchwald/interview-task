package com.autosystem.stub;

import com.autosystem.vehicle.vehiclepart.control.VehiclePartRepository;
import com.autosystem.vehicle.vehiclepart.model.VehiclePart;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class VehiclePartRepositoryStub implements VehiclePartRepository {

    public ArrayList<VehiclePart> vehicleParts = new ArrayList<>();

    @Override
    public ArrayList<VehiclePart> findAllByVehicleMarkAndVehicleModel(String mark, String model) {
        ArrayList<VehiclePart> matchingVehicleParts = new ArrayList<>();
        vehicleParts.forEach(vehiclePart -> {
            if (vehiclePart.vehicle.mark.equals(mark) && vehiclePart.vehicle.model.equals(model)) {
                matchingVehicleParts.add(vehiclePart);
            }
        });
        return matchingVehicleParts;
    }

    @Override
    public List<VehiclePart> findAll() {
        return null;
    }

    @Override
    public List<VehiclePart> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<VehiclePart> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<VehiclePart> findAllById(Iterable<UUID> iterable) {
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
    public void delete(VehiclePart vehiclePart) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends VehiclePart> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends VehiclePart> S save(S s) {
        vehicleParts.add(s);
        return s;
    }

    @Override
    public <S extends VehiclePart> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<VehiclePart> findById(UUID uuid) {
        for (VehiclePart vehiclePart : vehicleParts
        ) {
            if (uuid == vehiclePart.id) {
                return Optional.of(vehiclePart);
            }
        }

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
    public <S extends VehiclePart> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends VehiclePart> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<VehiclePart> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public VehiclePart getOne(UUID uuid) {
        return null;
    }

    @Override
    public VehiclePart getById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends VehiclePart> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends VehiclePart> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends VehiclePart> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends VehiclePart> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends VehiclePart> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends VehiclePart> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends VehiclePart, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

}

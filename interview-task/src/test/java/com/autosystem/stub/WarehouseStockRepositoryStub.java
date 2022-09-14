package com.autosystem.stub;

import com.autosystem.warehouse.warehousestock.control.WarehouseStockRepository;
import com.autosystem.warehouse.warehousestock.model.WarehouseStock;
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

public class WarehouseStockRepositoryStub implements WarehouseStockRepository {

    public ArrayList<WarehouseStock> warehouseStockList = new ArrayList<>();

    @Override
    public ArrayList<WarehouseStock> findAllByVehiclePart_Id(UUID vehiclePartId) {
        ArrayList<WarehouseStock> foundWarehouseStockItems = new ArrayList<>();
        warehouseStockList.forEach(warehouseStock -> {
            if(warehouseStock.vehiclePart.id == vehiclePartId){
                foundWarehouseStockItems.add(warehouseStock);
            }
        });
        return  foundWarehouseStockItems;
    }

    @Override
    public List<WarehouseStock> findAll() {
        return null;
    }

    @Override
    public List<WarehouseStock> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<WarehouseStock> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<WarehouseStock> findAllById(Iterable<UUID> iterable) {
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
    public void delete(WarehouseStock warehouseStock) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends WarehouseStock> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends WarehouseStock> S save(S s) {
        warehouseStockList.add(s);
        return s;
    }

    @Override
    public <S extends WarehouseStock> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<WarehouseStock> findById(UUID uuid) {
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
    public <S extends WarehouseStock> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends WarehouseStock> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<WarehouseStock> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public WarehouseStock getOne(UUID uuid) {
        return null;
    }

    @Override
    public WarehouseStock getById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends WarehouseStock> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends WarehouseStock> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends WarehouseStock> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends WarehouseStock> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends WarehouseStock> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends WarehouseStock> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends WarehouseStock, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

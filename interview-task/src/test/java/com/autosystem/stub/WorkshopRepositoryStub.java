package com.autosystem.stub;

import com.autosystem.workshop.workshop.control.WorkshopRepository;
import com.autosystem.workshop.workshop.model.Workshop;
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

public class WorkshopRepositoryStub implements WorkshopRepository {

    ArrayList<Workshop> workshopList = new ArrayList<>();

    @Override
    public List<Workshop> findAll() {
        return workshopList;
    }

    @Override
    public List<Workshop> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Workshop> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Workshop> findAllById(Iterable<UUID> iterable) {
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
    public void delete(Workshop workshop) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Workshop> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Workshop> S save(S s) {
        workshopList.add(s);
        return s;
    }

    @Override
    public <S extends Workshop> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Workshop> findById(UUID uuid) {
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
    public <S extends Workshop> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Workshop> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Workshop> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Workshop getOne(UUID uuid) {
        return null;
    }

    @Override
    public Workshop getById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Workshop> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Workshop> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Workshop> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Workshop> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Workshop> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Workshop> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Workshop, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

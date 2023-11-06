package com.example.springbootdocker.repos.impl;

import com.example.springbootdocker.entitys.Encounter;
import com.example.springbootdocker.repos.IEncounterRepo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class EncounterRepo implements IEncounterRepo {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Encounter> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Encounter> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Encounter> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Encounter getOne(Integer integer) {
        return null;
    }

    @Override
    public Encounter getById(Integer integer) {
        return null;
    }

    @Override
    public Encounter getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Encounter> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Encounter> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Encounter> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Encounter> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Encounter> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Encounter> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Encounter, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Encounter> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Encounter> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Encounter> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Encounter> findAll() {
        return null;
    }

    @Override
    public List<Encounter> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Encounter entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Encounter> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Encounter> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Encounter> findAll(Pageable pageable) {
        return null;
    }
}

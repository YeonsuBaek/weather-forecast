package com.weatherproject.weather.domain.repositoryImpl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.weatherproject.weather.domain.entity.Geographic;
import com.weatherproject.weather.domain.repository.GeographicRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Transactional
public class GeoGraphicRepositoryImpl implements GeographicRepository {

    private final JPAQueryFactory queryFactory;

    public GeoGraphicRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Geographic> findAll() {
        return null;
    }

    @Override
    public List<Geographic> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Geographic> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Geographic> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Geographic entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Geographic> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Geographic> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Geographic> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Geographic> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Geographic> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Geographic> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Geographic> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Geographic getOne(Long aLong) {
        return null;
    }

    @Override
    public Geographic getById(Long aLong) {
        return null;
    }

    @Override
    public Geographic getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Geographic> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Geographic> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Geographic> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Geographic> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Geographic> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Geographic> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Geographic, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Geographic> findDistinctCityByState(String state) {
        return null;
    }

    @Override
    public List<Geographic> findDistinctTownByStateAndCity(String state, String city) {
        return null;
    }

    @Override
    public Geographic findDistinctByStateAndCityAndTown(String state, String city, String town) {
        return null;
    }
}

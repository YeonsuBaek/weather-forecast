package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.DTO.CityDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeographicRepository extends JpaRepository<Geographic, Long> {

    List<Geographic> findAll();

    List<Geographic> findDistinctByState(String state);

}

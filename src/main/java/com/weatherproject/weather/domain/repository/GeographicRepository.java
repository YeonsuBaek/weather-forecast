package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.DTO.CityDTO;
import com.weatherproject.weather.domain.DTO.GeographicDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeographicRepository extends JpaRepository<Geographic, Long> {

    List<Geographic> findAll();

    //@Query(value = "SELECT DISTINCT city FROM geographic_coordinate g WHERE g.state = :state", nativeQuery = true)
    List<Geographic> findDistinctCityByState(String state);

    List<Geographic> findDistinctTownByStateAndCity(String state, String city);

}

package com.weatherproject.weather.service;

import com.weatherproject.weather.domain.DTO.CityDTO;
import com.weatherproject.weather.domain.DTO.GeographicDTO;
import com.weatherproject.weather.domain.DTO.StateDTO;
import com.weatherproject.weather.domain.DTO.TownDTO;
import com.weatherproject.weather.domain.entity.Geographic;

import java.util.List;

public interface GeographicService {

    public List<GeographicDTO> findAll(List<Geographic> Geographic);

    //GeographicRepository의 반환값을 StateDTO로 변환하여 반환
    public List<String> findState(List<Geographic> Geographic);

    //GeographicRepository의 반환값을 CityDTO로 변환하여 반환
    public List<String> findCity(List<Geographic> Geographic);

    public List<String> findTown(List<Geographic> Geographic);


}

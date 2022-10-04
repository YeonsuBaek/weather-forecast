package com.weatherproject.weather.service;

import com.weatherproject.weather.domain.DTO.ApiDataDTO;
import com.weatherproject.weather.domain.DTO.FcstApiDataDTO;

public interface WeatherRestAPIService {

    public ApiDataDTO weatherApiHandle(FcstApiDataDTO fcstApiDataDTO);
}

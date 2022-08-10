package com.weatherproject.weather.service;

import com.weatherproject.weather.domain.DTO.ApiUrlGeneratorDTO;
import com.weatherproject.weather.domain.DTO.CoordinateDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import org.springframework.web.util.UriComponents;
import reactor.core.publisher.Mono;

public interface WeatherAPIService {

    public UriComponents generateApiUrl(ApiUrlGeneratorDTO apiUrlGeneratorDTO);

    public Object getApiDate(UriComponents url);


}

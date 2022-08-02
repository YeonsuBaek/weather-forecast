package com.weatherproject.weather.service;

import com.weatherproject.weather.domain.DTO.ApiUrlGeneratorDTO;
import org.springframework.web.util.UriComponents;
import reactor.core.publisher.Mono;

public interface WeatherAPIService {

    public UriComponents generateApiUrl(ApiUrlGeneratorDTO apiUrlGeneratorDTO);

    public String getApiDate(UriComponents url);
}

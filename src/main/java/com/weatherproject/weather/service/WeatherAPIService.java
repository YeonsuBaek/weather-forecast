package com.weatherproject.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherproject.weather.domain.DTO.ApiUrlGeneratorDTO;
import com.weatherproject.weather.domain.DTO.CoordinateDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import org.json.simple.parser.ParseException;
import org.springframework.web.util.UriComponents;
import reactor.core.publisher.Mono;

public interface WeatherAPIService {

    public UriComponents generateApiUrl(ApiUrlGeneratorDTO apiUrlGeneratorDTO);

    public Object getApiDate(UriComponents url, ApiUrlGeneratorDTO apiUrlGeneratorDTO) throws JsonProcessingException, ParseException;


}

package com.weatherproject.weather.serviceImpl;

import com.weatherproject.weather.config.WeatherAPIConfig;
import com.weatherproject.weather.domain.DTO.ApiUrlGeneratorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@SpringBootTest
class WeatherAPIServiceImplTest {

    @Autowired
    WeatherAPIServiceImpl weatherAPIService;

    @Autowired
    WeatherAPIConfig weatherAPIConfig;

    @Test
    void urlTest() {
        String key = weatherAPIConfig.key;
        ApiUrlGeneratorDTO apiUrlGeneratorDTO = new ApiUrlGeneratorDTO(key, 954, 1, 20220802, 1700, "JSON", 61, 120);
        String url = String.valueOf(weatherAPIService.generateApiUrl(apiUrlGeneratorDTO));

        System.out.println(url);
    }

    @Test
    void apiTest() {
        String key = weatherAPIConfig.key;
        ApiUrlGeneratorDTO apiUrlGeneratorDTO = new ApiUrlGeneratorDTO(key, 954, 1, 20220802, 1700, "JSON", 61, 120);
        UriComponents url = weatherAPIService.generateApiUrl(apiUrlGeneratorDTO);

        Object response = weatherAPIService.getApiDate(url);
        System.out.println(response.toString());
    }

}
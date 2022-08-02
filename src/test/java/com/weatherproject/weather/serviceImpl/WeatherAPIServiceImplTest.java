package com.weatherproject.weather.serviceImpl;

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

    @Test
    void urlTest() {
        String key = "";
        ApiUrlGeneratorDTO apiUrlGeneratorDTO = new ApiUrlGeneratorDTO(key, 954, 1, 20220802, 1700, "JSON", 61, 120);
        String url = String.valueOf(weatherAPIService.generateApiUrl(apiUrlGeneratorDTO));

        System.out.println(url);
    }

    @Test
    void apiTest() {
        String key = "";
        ApiUrlGeneratorDTO apiUrlGeneratorDTO = new ApiUrlGeneratorDTO(key, 954, 1, 20220802, 1700, "JSON", 61, 120);
        UriComponents url = weatherAPIService.generateApiUrl(apiUrlGeneratorDTO);

        String response = weatherAPIService.getApiDate(url);
        System.out.println(response.toString());
    }

}
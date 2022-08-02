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
        String key = "nSmfjRDZ%2BV50faXQDrWwUeedWar2l0UM5KkCehAPcH%2BwjUF%2FR362qlgBd1mYU9xBIauT11l5O5OWvlCDS9PrqQ%3D%3D";
        ApiUrlGeneratorDTO apiUrlGeneratorDTO = new ApiUrlGeneratorDTO(key, 954, 1, 20220802, 1700, "JSON", 61, 120);
        String url = String.valueOf(weatherAPIService.generateApiUrl(apiUrlGeneratorDTO));

        System.out.println(url);
    }

    @Test
    void apiTest() {
        String key = "nSmfjRDZ%2BV50faXQDrWwUeedWar2l0UM5KkCehAPcH%2BwjUF%2FR362qlgBd1mYU9xBIauT11l5O5OWvlCDS9PrqQ%3D%3D";
        ApiUrlGeneratorDTO apiUrlGeneratorDTO = new ApiUrlGeneratorDTO(key, 954, 1, 20220802, 1700, "JSON", 61, 120);
        UriComponents url = weatherAPIService.generateApiUrl(apiUrlGeneratorDTO);

        String response = weatherAPIService.getApiDate(url);
        System.out.println(response.toString());
    }

}
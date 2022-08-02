package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.DTO.CityDTO;
import com.weatherproject.weather.domain.DTO.GeographicDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GeographicRepositoryTest {

    @Autowired
    GeographicRepository geographicRepository;

    @Test
    void 전부찾기() {
        List<Geographic> list = geographicRepository.findAll();
        System.out.println(list.get(2).toString() + "\n\n\n\n\n\n\n");
        Stream<Geographic> stream = list.stream();
    }

    @Test
    void 주별로도시찾기() {
        List<Geographic> list = geographicRepository.findDistinctCityByState("서울특별시");
        List<String> cityList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            cityList.add(list.get(i).getCity());
        }

        cityList.stream().distinct().forEach(name -> {System.out.println(name);});

    }
}
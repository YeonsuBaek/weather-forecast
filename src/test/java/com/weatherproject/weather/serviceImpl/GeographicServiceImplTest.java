package com.weatherproject.weather.serviceImpl;

import com.weatherproject.weather.domain.DTO.CityDTO;
import com.weatherproject.weather.domain.DTO.StateDTO;
import com.weatherproject.weather.domain.DTO.TownDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import com.weatherproject.weather.domain.repository.GeographicRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.weatherproject.weather.serviceImpl.GeographicServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ExtendWith(MockitoExtension.class)
class GeographicServiceImplTest {

    @Autowired
    GeographicServiceImpl geographicService;

    @Test
    void findByState() {
        List<Geographic> list = new ArrayList<>();
        Long no = Long.valueOf(0);
        Long area = Long.valueOf(1);

        Geographic geographic = new Geographic(no, "kor", area, "서울특별시", "종로구", "도곡동", 60, 127, 0, 0, 0, 0, 0);

        list.add(geographic);

        List<String> cityDTOS = geographicService.findCity(list);
        //Assertions.assertEquals(cityDTOS.get(0).getCity(), "종로구");

        //System.out.println(cityDTOS.get(0).toString());
    }

    @Test
    void findState() {
        List<Geographic> list = new ArrayList<>();
        Long no = Long.valueOf(0);
        Long area = Long.valueOf(1);

        Geographic geographic = new Geographic(no, "kor", area, "서울특별시", "종로구", "도곡동", 60, 127, 0, 0, 0, 0, 0);

        list.add(geographic);

        List<String> stateDTOS = geographicService.findState(list);
        //Assertions.assertEquals(stateDTOS.get(0).getState(), "서울특별시");
    }

    @Test
    void findByCity() {
        List<Geographic> list = new ArrayList<>();
        Long no = Long.valueOf(0);
        Long area = Long.valueOf(1);

        Geographic geographic = new Geographic(no, "kor", area, "서울특별시", "종로구", "도곡동", 60, 127, 0, 0, 0, 0, 0);

        list.add(geographic);

        Long no2 = Long.valueOf(0);
        Long area2 = Long.valueOf(1);

        Geographic geographic2 = new Geographic(no2, "kor", area2, "서울특별시", "종로구", "도곡동", 60, 127, 0, 0, 0, 0, 0);

        list.add(geographic2);

        List<String> townDTOS = geographicService.findTown(list);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(townDTOS.size() + " " + townDTOS.get(0).toString() + " " + townDTOS.get(1).toString());
        //Assertions.assertEquals(townDTOS.get(0).getTown(), "도곡동");

    }
}
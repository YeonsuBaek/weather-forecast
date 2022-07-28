package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.entity.VilageFcst;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
class VilageFcstRepositoryTest {
    @Autowired
    VilageFcstRepository vilageFcstRepository;

    VilageFcst vilageFcst = new VilageFcst(1, 1, 1, 1, 1, 1, "test", "test");

/*    @AfterEach
    void clear() {
        vilageFcstRepository.deleteAll();
    }*/


    @Test
    void insertTest() {

        System.out.println("vilage = " + vilageFcst.toString() + "\n\n\n\n\n\n");

        vilageFcstRepository.save(VilageFcst.builder().baseDate(vilageFcst.getBaseDate()).baseTime(vilageFcst.getBaseTime())
                .fcstDate(vilageFcst.getFcstDate())
                .fcstTime(vilageFcst.getFcstTime())
                        .x(vilageFcst.getX()).y(vilageFcst.getY()).category(vilageFcst.getCategory()).fcstValue(vilageFcst.getFcstValue()).
                build());

        /*vilageFcstRepository.save(VilageFcst.builder().baseDate(1).baseTime(1)
                .fcstDate(1)
                .fcstTime(1)
                .x(1).y(1).category("test").fcstValue("test").
                build());*/
    }

}
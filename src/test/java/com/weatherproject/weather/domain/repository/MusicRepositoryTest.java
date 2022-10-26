package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.DTO.MusicDTO;
import com.weatherproject.weather.domain.entity.Music;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RequiredArgsConstructor
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;

    @Test
    void findByWeather() {

        List<Music> musicDTOList = musicRepository.findByWeather("비");

        musicDTOList.stream().forEach(musicDTO -> System.out.println(musicDTO));
    }
}
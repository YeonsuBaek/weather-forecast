package com.weatherproject.weather.controller;

import com.weatherproject.weather.domain.DTO.MusicDTO;
import com.weatherproject.weather.domain.repository.MusicRepository;
import com.weatherproject.weather.service.MusicService;
import com.weatherproject.weather.serviceImpl.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class MusicController {

    private final MusicServiceImpl musicService;

    @Autowired
    public MusicController(MusicService musicService, MusicRepository musicRepository) {
        this.musicService = (MusicServiceImpl) musicService;
    }

    @RequestMapping("restapi/music/findByWeather")
    public List<MusicDTO> musicRecommend(@RequestParam(value="weather") String weather) {
        //예시 https://hsweatherapi.xyz/restapi/music/findByWeather?weather=눈
        //비/눈/맑음/흐림
        List<MusicDTO> musicList = musicService.musicByWeather(weather);
        List<MusicDTO> musicRecommendList = new ArrayList<>();

        Collections.shuffle(musicList);

        for (int i = 0; i < 1; i++) {
            musicRecommendList.add(musicList.get(i));
        }

        return musicRecommendList;
    }
}

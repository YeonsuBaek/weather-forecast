package com.weatherproject.weather.service;

import com.weatherproject.weather.domain.DTO.MusicDTO;

import java.util.List;

public interface MusicService {

    //날씨에 따라 추천 음악 목록을 반환
    public List<MusicDTO> musicByWeather(String weather);
}

package com.weatherproject.weather.serviceImpl;

import com.weatherproject.weather.domain.DTO.MusicDTO;
import com.weatherproject.weather.domain.entity.Music;
import com.weatherproject.weather.domain.repository.MusicRepository;
import com.weatherproject.weather.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    public final MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<MusicDTO> musicByWeather(String weather) {

        List<Music> musicList = musicRepository.findByWeather(weather);
        List<MusicDTO> musicDTOList = new ArrayList<>();

        for (int i = 0; i < musicList.size(); i++) {
            int index = musicList.get(i).getLink().indexOf("=");

            String embedUrl = "https://www.youtube.com/embed/" + musicList.get(i).getLink().substring(index + 1);
            MusicDTO musicDTOTemp = new MusicDTO(musicList.get(i).getTitle(), musicList.get(i).getSinger(), embedUrl, musicList.get(i).getWeather());
            musicDTOList.add(musicDTOTemp);
        }

        return musicDTOList;
    }
}

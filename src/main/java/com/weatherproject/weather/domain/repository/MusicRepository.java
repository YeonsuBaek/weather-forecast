package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.DTO.MusicDTO;
import com.weatherproject.weather.domain.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MusicRepository extends JpaRepository<Music, Long> {

    List<Music> findByWeather(String weather);
}

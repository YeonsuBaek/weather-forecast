package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.entity.VilageFcst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VilageFcstRepository extends JpaRepository<VilageFcst, Long> {

    
}

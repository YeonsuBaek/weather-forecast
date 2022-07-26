package com.weatherproject.weather.serviceImpl;

import com.weatherproject.weather.domain.DTO.CityDTO;
import com.weatherproject.weather.domain.DTO.GeographicDTO;
import com.weatherproject.weather.domain.DTO.StateDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import com.weatherproject.weather.service.GeographicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeographicServiceImpl implements GeographicService {

    @Override
    public List<GeographicDTO> findAll(List<Geographic> geographic) {
        List<GeographicDTO> geographicDTOS = new ArrayList<>();

        for (int i = 0; i < geographic.size(); i++) {
            GeographicDTO geographicDTOTemp = new GeographicDTO(geographic.get(i).getNo(),
                    geographic.get(i).getArea(),
                    geographic.get(i).getState(),
                    geographic.get(i).getCity(),
                    geographic.get(i).getGrid_X(),
                    geographic.get(i).getGrid_Y()
                    );

            geographicDTOS.add(geographicDTOTemp);
        }

        return geographicDTOS;
    }

    @Override
    public List<StateDTO> findState(List<Geographic> geographic) {

        List<StateDTO> stateDTOS = new ArrayList<>();

        for (int i = 0; i < geographic.size(); i++) {
            StateDTO stateDTOTemp = new StateDTO(geographic.get(i).getState());
            stateDTOS.add(stateDTOTemp);
        }

        return stateDTOS;
    }

    @Override
    public List<CityDTO> findByState(List<Geographic> geographic) {

        List<CityDTO> cityDTOS = new ArrayList<>();

        for (int i = 0; i < geographic.size(); i++) {
            CityDTO cityDTOTemp = new CityDTO(geographic.get(i).getCity());
            cityDTOTemp.setCity(geographic.get(i).getCity());

            cityDTOS.add(cityDTOTemp);
        }

        cityDTOS = cityDTOS.stream().distinct().collect(Collectors.toList());

        return cityDTOS;
    }
}

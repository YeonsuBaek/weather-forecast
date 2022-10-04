package com.weatherproject.weather.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherproject.weather.config.WeatherAPIConfig;
import com.weatherproject.weather.domain.DTO.ApiDataDTO;
import com.weatherproject.weather.domain.DTO.ApiUrlGeneratorDTO;
import com.weatherproject.weather.domain.DTO.CoordinateDTO;
import com.weatherproject.weather.domain.DTO.FcstApiDataDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import com.weatherproject.weather.domain.repository.GeographicRepository;
import com.weatherproject.weather.service.WeatherRestAPIService;
import com.weatherproject.weather.serviceImpl.GeographicServiceImpl;
import com.weatherproject.weather.serviceImpl.WeatherAPIServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherRestApiController {

    private final GeographicRepository geographicRepository;
    private final GeographicServiceImpl geographicService;

    private final WeatherAPIServiceImpl weatherAPIService;

    private final WeatherRestAPIService weatherRestAPIService;

    public WeatherRestApiController(GeographicRepository geographicRepository, GeographicServiceImpl geographicService, WeatherAPIServiceImpl weatherAPIService, WeatherRestAPIService weatherRestAPIService) {
        this.geographicRepository = geographicRepository;
        this.geographicService = geographicService;
        this.weatherAPIService = weatherAPIService;
        this.weatherRestAPIService = weatherRestAPIService;
    }

    @RequestMapping("/restapi/weather/findState")
    public List<String> findState() {
        List<String> list = new ArrayList<>();
        List<Geographic> geographicList = geographicRepository.findAll();

        list = geographicService.findState(geographicList);

        return list;
    }

    @RequestMapping("/restapi/weather/findCity")
    public List<String> findCity(
            @RequestParam(value = "state") String state
    ) {
        List<String> list = new ArrayList<>();
        List<Geographic> geographicList = geographicRepository.findDistinctCityByState(state);

        list = geographicService.findCity(geographicList);

        return list;
    }

    @RequestMapping("/restapi/weather/findTown")
    public List<String> findTown(
            @RequestParam(value = "state") String state,
            @RequestParam(value = "city") String city
    ) {
        List<String> list = new ArrayList<>();
        List<Geographic> geographicList = geographicRepository.findDistinctTownByStateAndCity(state, city);

        list = geographicService.findTown(geographicList);

        return list;
    }

    @RequestMapping(value = "/restapi/weather/fcst/{baseDate}/{baseTime}", method = RequestMethod.GET)
    public Object getApiInfo(
            @PathVariable(value = "baseDate") String baseDate,
            @PathVariable(value = "baseTime") String baseTime,
            @RequestParam(value = "state") String state,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "town") String town
    ) throws JsonProcessingException, ParseException {

        //예시
        //http://localhost:8091/restapi/weather/fcst/20221004/1400?state=%EA%B2%BD%EA%B8%B0%EB%8F%84&city=%EC%98%A4%EC%82%B0%EC%8B%9C&town=%EC%84%B8%EB%A7%88%EB%8F%99

        String key = WeatherAPIConfig.key;

        Geographic geographic = geographicRepository.findDistinctByStateAndCityAndTown(state, city, town);

        CoordinateDTO coordinateDTO = geographicService.getCoordinate(geographic);

        ApiUrlGeneratorDTO apiUrlGeneratorDTO = new ApiUrlGeneratorDTO(key, 954, 1, Integer.parseInt(baseDate), Integer.parseInt(baseTime), "JSON", coordinateDTO.getNx(), coordinateDTO.getNy());
        UriComponents url = weatherAPIService.generateApiUrl(apiUrlGeneratorDTO);


        List<FcstApiDataDTO> response = weatherAPIService.getApiDate(url, apiUrlGeneratorDTO);

        List<ApiDataDTO> result = new ArrayList<>();


        for (int i = 0; i < response.size(); i++) {

            String category = response.get(i).getCategory();

            if (!category.equals("UUU") && !category.equals("VVV") && !category.equals("WAV") && !category.equals("VEC")) {
                ApiDataDTO apiDataDTO = weatherRestAPIService.weatherApiHandle(response.get(i));
                result.add(apiDataDTO);
            }
            else
                continue;
        }

        return result;
    }
}

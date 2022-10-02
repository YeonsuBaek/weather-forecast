package com.weatherproject.weather.service;

import com.weatherproject.weather.domain.DTO.ApiDataDTO;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.util.List;

public interface ApiDataJsonExtractService {

    public JSONArray extractData(String response) throws ParseException;
}

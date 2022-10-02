package com.weatherproject.weather.service;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.util.List;

public interface ApiDataJsonExtractService {

    public JSONArray extractData(String response) throws ParseException;
}

package com.weatherproject.weather.serviceImpl;

import com.weatherproject.weather.domain.DTO.ApiDataDTO;
import com.weatherproject.weather.service.ApiDataJsonExtractService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApiDataJsonExtractServiceImpl implements ApiDataJsonExtractService {

    @Override
    public JSONArray extractData(String response) throws ParseException {

        //API 데이터 전체를 파싱해서 JSON으로 변환
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response);

        //jsonObject에서 response 가져오기
        JSONObject parseResponse = (JSONObject) jsonObject.get("response");

        //response에서 body 가져오기
        JSONObject parseBody = (JSONObject) parseResponse.get("body");

        //body에서 items 가져오기
        JSONObject pareItems = (JSONObject) parseBody.get("items");

        //items에서 item 가져오기
        JSONArray parseItem = (JSONArray) pareItems.get("item");

        return parseItem;
    }
}

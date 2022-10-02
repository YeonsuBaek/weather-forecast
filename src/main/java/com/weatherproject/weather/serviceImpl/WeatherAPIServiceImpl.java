package com.weatherproject.weather.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.weatherproject.weather.config.WeatherAPIConfig;
import com.weatherproject.weather.domain.DTO.ApiDataDTO;
import com.weatherproject.weather.domain.DTO.ApiUrlGeneratorDTO;
import com.weatherproject.weather.domain.DTO.CoordinateDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import com.weatherproject.weather.service.WeatherAPIService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherAPIServiceImpl implements WeatherAPIService {


    WeatherAPIConfig weatherAPIConfig;
    ApiDataJsonExtractServiceImpl apiDataJsonExtractService;

    public WeatherAPIServiceImpl(WeatherAPIConfig weatherAPIConfig, ApiDataJsonExtractServiceImpl apiDataJsonExtractService) {

        this.weatherAPIConfig = weatherAPIConfig;
        this.apiDataJsonExtractService = apiDataJsonExtractService;
    }

    private final String BASE_URL = weatherAPIConfig.baseUrl;
    private final String API_KEY = weatherAPIConfig.key;

    //기상청 API URL 생성
    @Override
    public UriComponents generateApiUrl(ApiUrlGeneratorDTO apiUrlGeneratorDTO) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("apis.data.go.kr")
                .path("1360000/VilageFcstInfoService_2.0/getVilageFcst")
                .queryParam("serviceKey", apiUrlGeneratorDTO.getServiceKey())
                .queryParam("numOfRows", apiUrlGeneratorDTO.getNumOfRows())
                .queryParam("pageNo", apiUrlGeneratorDTO.getPageNo())
                .queryParam("base_date", apiUrlGeneratorDTO.getBaseDate())
                .queryParam("base_time", apiUrlGeneratorDTO.getBaseTime())
                .queryParam("dataType", apiUrlGeneratorDTO.getDataType())
                .queryParam("nx", apiUrlGeneratorDTO.getNx())
                .queryParam("ny", apiUrlGeneratorDTO.getNy()).build();


        return uriComponents;
    }

    //기상청에서 API 데이터 JSON으로 가져오기
    @Override
    public List<ApiDataDTO> getApiDate(UriComponents url, ApiUrlGeneratorDTO apiUrlGeneratorDTO) throws ParseException {

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(BASE_URL);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient client = client = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(BASE_URL)
                .build();

        List<ApiDataDTO> result = new ArrayList<>();
        //ObjectMapper objectMapper = new ObjectMapper();


        String response = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getVilageFcst")
                        .queryParam("serviceKey" , API_KEY)
                        .queryParam("numOfRows", 954)
                        .queryParam("pageNo", 1)
                        .queryParam("base_date", apiUrlGeneratorDTO.getBaseDate())
                        .queryParam("base_time", apiUrlGeneratorDTO.getBaseTime())
                        .queryParam("dataType", "JSON")
                        .queryParam("nx", apiUrlGeneratorDTO.getNx())
                        .queryParam("ny", apiUrlGeneratorDTO.getNy()).build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //result = Arrays.asList(objectMapper.readValue(response, ApiDataDTO[].class));
        //result = response.collect(Collectors.toList()).share().block();
        JSONArray dataArray = apiDataJsonExtractService.extractData(response);

        for (int i = 0; i < dataArray.size(); i++) {
            JSONObject objectTemp = (JSONObject) dataArray.get(i);
            ApiDataDTO apiDataDTOTemp = new ApiDataDTO((String) objectTemp.get("baseDate"),
                    (String) objectTemp.get("baseTime"),
                    (String) objectTemp.get("category"),
                    (String) objectTemp.get("fcstDate"),
                    (String) objectTemp.get("fcstTime"),
                    (String) objectTemp.get("fcstValue"),
                    String.valueOf(objectTemp.get("nx")),
                    String.valueOf(objectTemp.get("ny"))
            );

            result.add(apiDataDTOTemp);
            //JSONObject objectTemp = (JSONObject) dataArray.get(i);
            //System.out.println("nx : " + objectTemp.get("nx"));
            //result.add(dataArray.get(i));
        }

        return result;

    }

}

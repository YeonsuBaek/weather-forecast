package com.weatherproject.weather.serviceImpl;

import com.weatherproject.weather.config.WeatherAPIConfig;
import com.weatherproject.weather.domain.DTO.ApiDataDTO;
import com.weatherproject.weather.domain.DTO.ApiUrlGeneratorDTO;
import com.weatherproject.weather.domain.DTO.CoordinateDTO;
import com.weatherproject.weather.domain.entity.Geographic;
import com.weatherproject.weather.service.WeatherAPIService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WeatherAPIServiceImpl implements WeatherAPIService {


    WeatherAPIConfig weatherAPIConfig;

    public WeatherAPIServiceImpl(WeatherAPIConfig weatherAPIConfig) {
        this.weatherAPIConfig = weatherAPIConfig;
    }

    private final static String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0";
    private final String API_KEY = weatherAPIConfig.key;

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

    @Override
    public Object getApiDate(UriComponents url) {
        /*WebClient client = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<Object[]> response = client.get().uri(url).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Object[].class);

        return response;*/

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(BASE_URL);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient client = client = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(BASE_URL)
                .build();

        Object response = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getVilageFcst")
                        .queryParam("serviceKey" , API_KEY)
                        .queryParam("numOfRows", 954)
                        .queryParam("pageNo", 1)
                        .queryParam("base_date", 20220802)
                        .queryParam("base_time", 2000)
                        .queryParam("dataType", "JSON")
                        .queryParam("nx", 61)
                        .queryParam("ny", 120).build()
                ).retrieve().bodyToMono(Object.class).block();

        return response;

    }

}

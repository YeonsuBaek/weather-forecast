package com.weatherproject.weather.domain.DTO.fcstValue;

public class SkyVO {

    int code;

    public String getResult() {
        if (code == 1)
            return "맑음";
        else if (code == 3)
            return "구름많음";
        else
            return "흐름";
    }
}

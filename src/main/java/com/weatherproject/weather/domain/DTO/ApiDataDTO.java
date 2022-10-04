package com.weatherproject.weather.domain.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiDataDTO {

    //프론트엔드에 넘겨줄 실질적인 API Data JSON 객체

    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
}

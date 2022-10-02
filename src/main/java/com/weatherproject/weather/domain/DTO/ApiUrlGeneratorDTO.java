package com.weatherproject.weather.domain.DTO;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiUrlGeneratorDTO {

    private String serviceKey;
    private int numOfRows;
    private int pageNo;
    private int baseDate;
    private int baseTime;
    private String dataType;
    private long nx;
    private long ny;
}

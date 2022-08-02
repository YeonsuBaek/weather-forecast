package com.weatherproject.weather.domain.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GeographicDTO {

    public Long no;
    public Long area;
    public String state;
    public String city;
    public Long gridX;
    public Long gridY;

}

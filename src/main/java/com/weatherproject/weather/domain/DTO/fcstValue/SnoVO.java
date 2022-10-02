package com.weatherproject.weather.domain.DTO.fcstValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class SnoVO {

    double value;

    public SnoVO(double value) {
        this.value = value;
    }

    public String getResult() {
        if (value < 1.0)
            return  "1.0cm 미만";
        else if (value >= 1.0f && value < 5.0f)
            return value + "cm";
        else
            return "5.0cm 이상";
    }
}

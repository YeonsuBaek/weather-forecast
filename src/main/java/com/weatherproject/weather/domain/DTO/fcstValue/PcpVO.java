package com.weatherproject.weather.domain.DTO.fcstValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class PcpVO {

    double value;

    public PcpVO(double value) {
        this.value = value;
    }

    public String getResult() {
        if (value < 1.0)
            return  "1.0mm미만 ";
        else if (value >= 1.0f && value < 30.0f)
            return "1.0~29.0mm";
        else if (value >= 30.0f && value < 50.0f)
            return "30.0~50.0mm";
        else
            return "50.0mm이상";
    }


}

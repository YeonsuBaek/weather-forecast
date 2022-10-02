package com.weatherproject.weather.domain.DTO.fcstValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class PtyVO {

    int code;

    public PtyVO(int code) {
        this.code = code;
    }

    String[] weatherCode = {"없음", "비", "비/눈", "눈", "소나기"};
    String result = weatherCode[code];
}

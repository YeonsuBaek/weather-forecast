package com.weatherproject.weather.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "vilagefcst")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VilageFcst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    private long baseDate;

    private long baseTime;

    private long fcstDate;

    private long fcstTime;
    private long x;
    private long y;
    private String category;

    private String fcstValue;

    public VilageFcst(long baseDate, long baseTime, long fcstDate, long fcstTime, long x, long y, String category, String fcstValue) {
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.fcstDate = fcstDate;
        this.fcstTime = fcstTime;
        this.x = x;
        this.y = y;
        this.category = category;
        this.fcstValue = fcstValue;
    }
}

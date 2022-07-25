package com.weatherproject.weather.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="geographic_coordinate")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Geographic {

    @Id
    @Column(nullable = false)
    private Long no;
    private String country;
    private Long area;
    private String state;
    private String city;
    private String town;
    private long gridX;
    private long gridY;
    private long longitudeHour;
    private long longitudeMinute;
    private double longitudeSecond;
    private double longitude;
    private double latitude;


}

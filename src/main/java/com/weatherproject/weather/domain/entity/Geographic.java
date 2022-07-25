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
    private long grid_x;
    private long grid_y;
    private long longitude_hour;
    private long longitude_minute;
    private double longitude_second;
    private double longitude;
    private double latitude;


}

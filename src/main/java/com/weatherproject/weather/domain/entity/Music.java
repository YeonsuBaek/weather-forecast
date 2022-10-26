package com.weatherproject.weather.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="music")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Music {

    @Id
    @Column(nullable = false)
    private String title;
    private String singer;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private String weather;
}

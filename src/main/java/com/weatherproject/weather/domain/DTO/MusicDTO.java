package com.weatherproject.weather.domain.DTO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MusicDTO {

    private String title;
    private String singer;
    private String link;
    private String weather;
}

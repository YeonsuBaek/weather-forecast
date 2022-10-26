package com.weatherproject.weather.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="hanshin_number")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HanshinNumber {

    @Id
    @Column(nullable = false)
    private Long num;
    private String department;
    @Column(name = "department_detail")
    private String departmentDetail;
    private String name;
    private String phone;
    private String room;
}

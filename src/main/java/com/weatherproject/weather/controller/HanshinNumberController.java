package com.weatherproject.weather.controller;

import com.weatherproject.weather.domain.entity.HanshinNumber;
import com.weatherproject.weather.domain.repository.HanshinNumberRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HanshinNumberController {

    private final HanshinNumberRepository hanshinNumberRepository;


    public HanshinNumberController(HanshinNumberRepository hanshinNumberRepository) {
        this.hanshinNumberRepository = hanshinNumberRepository;
    }

    @RequestMapping("restapi/hanshinnumber/findall")
    public List<HanshinNumber> findAll() {
        List<HanshinNumber> hanshinNumberList = hanshinNumberRepository.findAll();

        return hanshinNumberList;
    }

    @RequestMapping("restapi/hanshinnumber/findbydepartment")
    public List<HanshinNumber> findByDepartment(@RequestParam(value="department") String department) {
        // https://hsweatherapi.xyz/restapi/hanshinnumber/findbydepartment?department=교무팀장
        List<HanshinNumber> hanshinNumbers = hanshinNumberRepository.findByDepartmentDetailContaining(department);

        return hanshinNumbers;
    }

    @RequestMapping("restapi/hanshinnumber/findbyphone")
    public List<HanshinNumber> findByPhone(@RequestParam(value="phone") String phone) {

        //예시 https://hsweatherapi.xyz/restapi/hanshinnumber/findbyphone?phone=031
        List<HanshinNumber> hanshinNumbers = hanshinNumberRepository.findByPhoneContaining(phone);

        return hanshinNumbers;
    }
}

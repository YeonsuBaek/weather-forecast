package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.entity.HanshinNumber;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HanshinNumberRepositoryTest {

    @Autowired
    HanshinNumberRepository hanshinNumberRepository;

    @Test
    void 전부찾기() {
        List<HanshinNumber> hanshinNumbers = hanshinNumberRepository.findAll();
        //System.out.println(hanshinNumbers.get(2).getDepartment());
        hanshinNumbers.stream().forEach(detail -> {System.out.println(detail);});
    }

    @Test
    void findByDepartmentDetailContaining() {

        List<HanshinNumber> hanshinNumbers = hanshinNumberRepository.findByDepartmentDetailContaining("대외");

        hanshinNumbers.stream().forEach(detail -> {System.out.println(detail);});
    }

    @Test
    void findByPhoneContaining() {

        List<HanshinNumber> hanshinNumbers = hanshinNumberRepository.findByPhoneContaining("031-379");

        hanshinNumbers.stream().forEach(phone -> {System.out.println(phone);});
    }
}
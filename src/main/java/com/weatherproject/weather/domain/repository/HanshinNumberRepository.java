package com.weatherproject.weather.domain.repository;

import com.weatherproject.weather.domain.entity.HanshinNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface HanshinNumberRepository extends JpaRepository<HanshinNumber, Long> {

    List<HanshinNumber> findAll();

    List<HanshinNumber> findByDepartmentDetailContaining(String departmentDetail);

    List<HanshinNumber> findByPhoneContaining(String phone);

}

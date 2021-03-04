package com.boc.test.weather.repository;

import com.boc.test.weather.entity.WeatherStation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface WeatherStationRepository extends PagingAndSortingRepository<WeatherStation, Long> {

    Page<WeatherStation> findAllByDateGreaterThanEqualAndDateLessThanEqual(Timestamp startDate,
                                                                       Timestamp endDate, Pageable pageable);
}

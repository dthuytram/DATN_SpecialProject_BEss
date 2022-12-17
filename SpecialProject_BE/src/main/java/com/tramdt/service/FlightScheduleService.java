package com.tramdt.service;

import com.tramdt.dto.FlightSearchDTO;
import com.tramdt.model.FlightSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlightScheduleService {
    Page<FlightSchedule> findAllFlightSchedule(Pageable pageable);

    List<FlightSchedule> searchFlights(FlightSearchDTO flights);

    //hàm employee tìm chuyến bay
    Page<FlightSchedule> findAllFlightScheduleByEmployee(long deptPlaceId, long arrPlaceId, String deptDate,
                                                         int capacity, String status, Pageable pageable);

    // hàm tìm kiếm chuyến bay theo id
    FlightSchedule findFlightById(Long id);
}

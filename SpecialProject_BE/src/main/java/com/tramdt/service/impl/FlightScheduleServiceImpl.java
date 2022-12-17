package com.tramdt.service.impl;

import com.tramdt.dto.FlightSearchDTO;
import com.tramdt.model.FlightSchedule;
import com.tramdt.repository.FlightScheduleRepository;
import com.tramdt.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    //employee tìm kiếm chuyến bay
    @Override
    public Page<FlightSchedule> findAllFlightScheduleByEmployee(long deptPlaceId, long arrPlaceId, String deptDate, int capacity, String status, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(),5);
        return flightScheduleRepository.findAllFlightScheduleByEmployee(deptPlaceId,arrPlaceId,deptDate,capacity,status,pageable);
    }

    //tim kiem chuyen bay
    @Override
    public FlightSchedule findFlightById(Long id) {
        return flightScheduleRepository.findById(id).orElse(null);
    }

    private final Map<String, String> sortType = new HashMap<>();
    {
        sortType.put("priceUp", "price");
        sortType.put("priceDown", "price");
        sortType.put("time", "departureDateTime");
        sortType.put("branch", "branch.name");
    }

    @Override
    public Page<FlightSchedule> findAllFlightSchedule(Pageable pageable) {
        return flightScheduleRepository.findAll(pageable);
    }

    @Override
    public List<FlightSchedule> searchFlights(FlightSearchDTO flights) {
        LocalDateTime from;
        if (flights.getDepDate().compareTo(LocalDate.now()) == 0) {
            LocalDateTime now = LocalDateTime.now();
            from = now.plusHours(4);
        } else {
            from = LocalDateTime.of(flights.getDepDate(), LocalTime.of(0, 0));
        }
        LocalDateTime to = LocalDateTime.of(flights.getDepDate(), LocalTime.of(23, 59));
        Sort sort = getSort(flights.getSortBy()) ;
        return flightScheduleRepository.findAllFlightSchedules(flights.getDeparture(), flights.getArrival(), from, to, sort);
    }

    private Sort getSort(String type) {
        if ("".equals(type))
            return null;
        if ("priceDown".equals(type)) {
            return Sort.by(Sort.Direction.DESC, sortType.get(type));
        }
        return Sort.by(sortType.get(type));
    }
}

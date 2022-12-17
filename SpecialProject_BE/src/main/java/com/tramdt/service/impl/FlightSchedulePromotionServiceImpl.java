package com.tramdt.service.impl;

import com.tramdt.dto.FlightSearchDTO;
import com.tramdt.model.FlightSchedule;
import com.tramdt.repository.FlightSchedulePromotionRepository;
import com.tramdt.service.FlightSchedulePromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightSchedulePromotionServiceImpl implements FlightSchedulePromotionService {

    @Autowired
    private FlightSchedulePromotionRepository flightSchedulePromotionRepository;

//    private final Map<String, String> sortType = new HashMap<>();
//    {
//        sortType.put("priceUp", "price");
//        sortType.put("priceDown", "price");
//        sortType.put("time", "departureDateTime");
//        sortType.put("branch", "branch.name");
//    }


    @Override
    public List<FlightSchedule> searchFlightsPromotion(FlightSearchDTO flights) {
        LocalDateTime from = LocalDateTime.of(flights.getDepDate(), LocalTime.of(0, 0));
        LocalDateTime to = LocalDateTime.of(flights.getDepDate(), LocalTime.of(23, 59));
//        Sort sort = getSort(flights.getSortBy()) ;
        return flightSchedulePromotionRepository.findAllFlightSchedulesPromotion(flights.getDeparture(), flights.getArrival(), from, to);
    }

    @Override
    public List<FlightSchedule> listFlightsPromotion(LocalDate dateFromTo) {
        LocalDateTime from = LocalDateTime.of(dateFromTo, LocalTime.of(0, 0));
        LocalDateTime to = LocalDateTime.of(dateFromTo, LocalTime.of(23, 59));
        return flightSchedulePromotionRepository.listFlightSchedulesPromotion(from , to);
    }


//    private Sort getSort(String type) {
//        if ("".equals(type))
//            return null;
//        if ("priceDown".equals(type)) {
//            return Sort.by(Sort.Direction.DESC, sortType.get(type));
//        }
//        return Sort.by(sortType.get(type));
//    }

}

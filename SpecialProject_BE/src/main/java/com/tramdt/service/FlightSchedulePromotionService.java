package com.tramdt.service;

import com.tramdt.dto.FlightSearchDTO;
import com.tramdt.model.FlightSchedule;


import java.time.LocalDate;
import java.util.List;

public interface FlightSchedulePromotionService {
    List<FlightSchedule> searchFlightsPromotion(FlightSearchDTO flights);
    List<FlightSchedule> listFlightsPromotion(LocalDate dateFromTo);
}

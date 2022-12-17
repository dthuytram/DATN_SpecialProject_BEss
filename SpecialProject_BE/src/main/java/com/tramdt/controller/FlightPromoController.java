package com.tramdt.controller;

import com.tramdt.dto.FlightSearchDTO;
import com.tramdt.exception.excep.ViolatedException;
import com.tramdt.model.FlightSchedule;
import com.tramdt.service.AirportService;
import com.tramdt.service.PromoService;
import com.tramdt.service.impl.FlightSchedulePromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class FlightPromoController {

    @Autowired
    private FlightSchedulePromotionServiceImpl flightSchedulePromotionService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private PromoService promoService;
    // Get all airport
    @PostMapping("/flight-promotion")
    public ResponseEntity<List<FlightSchedule>> ListSchedulePromotion(@RequestBody FlightSearchDTO flights)   throws ViolatedException {
        List<FlightSchedule>  flightSchedules = flightSchedulePromotionService.searchFlightsPromotion(flights);
        return ResponseEntity.ok(flightSchedules);
    }

    @GetMapping("/promotion")
    public ResponseEntity<List<FlightSchedule>> ListDateSchedulePromotion(@RequestParam String departureAirport)   throws ViolatedException {
        List<FlightSchedule>  dateFlightSchedules = flightSchedulePromotionService.listFlightsPromotion(LocalDate.parse(departureAirport));
        return ResponseEntity.ok(dateFlightSchedules);
    }

    
}

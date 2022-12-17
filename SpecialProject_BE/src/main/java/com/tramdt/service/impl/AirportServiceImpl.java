package com.tramdt.service.impl;

import com.tramdt.model.Airport;
import com.tramdt.repository.AirportRepository;
import com.tramdt.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> getAirports() {
        return airportRepository.findAll();
    }

    @Override
    public List<Airport> findAllAirport() {
        return airportRepository.findAll();
    }
}

package com.tramdt.service;

import com.tramdt.model.Airport;

import java.util.List;

public interface AirportService {

    List<Airport> getAirports();
    List<Airport> findAllAirport();
}

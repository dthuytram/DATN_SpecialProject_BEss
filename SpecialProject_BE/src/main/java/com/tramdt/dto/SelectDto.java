package com.tramdt.dto;

import com.tramdt.model.Airport;
import com.tramdt.model.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



public class SelectDto {
    List<Airport> airports;
    List<Branch> brands;

    public SelectDto() {
    }

    public SelectDto(List<Airport> airports, List<Branch> brands) {
        this.airports = airports;
        this.brands = brands;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Branch> getBrands() {
        return brands;
    }

    public void setBrands(List<Branch> brands) {
        this.brands = brands;
    }
}

package com.tramdt.dto;

import com.tramdt.model.Airport;
import lombok.Data;

//search flight schedule trong employee

public class EmployeeFlightSearchDTO {
    private Airport departurePlace;
    private Airport arrivalPlace;
    private String departureDate;
    private String arrivalDate;
    private int adult;
    private int child;
    private int baby;

    public Airport getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(Airport departurePlace) {
        this.departurePlace = departurePlace;
    }

    public Airport getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(Airport arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getBaby() {
        return baby;
    }

    public void setBaby(int baby) {
        this.baby = baby;
    }
}

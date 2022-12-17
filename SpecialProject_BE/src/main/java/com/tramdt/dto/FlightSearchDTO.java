package com.tramdt.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class FlightSearchDTO {

    private String sortBy;
    private Long departure;
    private Long arrival;
    private LocalDate depDate;
    private byte babies;
    private byte children;
    private byte adults;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Long getDeparture() {
        return departure;
    }

    public void setDeparture(Long departure) {
        this.departure = departure;
    }

    public Long getArrival() {
        return arrival;
    }

    public void setArrival(Long arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDepDate() {
        return depDate;
    }

    public void setDepDate(LocalDate depDate) {
        this.depDate = depDate;
    }

    public byte getBabies() {
        return babies;
    }

    public void setBabies(byte babies) {
        this.babies = babies;
    }

    public byte getChildren() {
        return children;
    }

    public void setChildren(byte children) {
        this.children = children;
    }

    public byte getAdults() {
        return adults;
    }

    public void setAdults(byte adults) {
        this.adults = adults;
    }
}

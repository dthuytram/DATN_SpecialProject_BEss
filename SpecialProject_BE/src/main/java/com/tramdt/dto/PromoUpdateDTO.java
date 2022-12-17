package com.tramdt.dto;

import com.tramdt.model.Airport;
import com.tramdt.model.Branch;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


@NoArgsConstructor
public class PromoUpdateDTO {
    private Long id;
    private String namePromo;
    private Double discount;
    private Branch airline;
    private Airport departurePlace;
    private Airport arrivalPlace;
    private LocalDateTime flightDepartureDateStart;
    private LocalDateTime flightDepartureDateEnd;
    private LocalDateTime promoDateStart;
    private LocalDateTime promoDateEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePromo() {
        return namePromo;
    }

    public void setNamePromo(String namePromo) {
        this.namePromo = namePromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Branch getAirline() {
        return airline;
    }

    public void setAirline(Branch airline) {
        this.airline = airline;
    }

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

    public LocalDateTime getFlightDepartureDateStart() {
        return flightDepartureDateStart;
    }

    public void setFlightDepartureDateStart(LocalDateTime flightDepartureDateStart) {
        this.flightDepartureDateStart = flightDepartureDateStart;
    }

    public LocalDateTime getFlightDepartureDateEnd() {
        return flightDepartureDateEnd;
    }

    public void setFlightDepartureDateEnd(LocalDateTime flightDepartureDateEnd) {
        this.flightDepartureDateEnd = flightDepartureDateEnd;
    }

    public LocalDateTime getPromoDateStart() {
        return promoDateStart;
    }

    public void setPromoDateStart(LocalDateTime promoDateStart) {
        this.promoDateStart = promoDateStart;
    }

    public LocalDateTime getPromoDateEnd() {
        return promoDateEnd;
    }

    public void setPromoDateEnd(LocalDateTime promoDateEnd) {
        this.promoDateEnd = promoDateEnd;
    }
}

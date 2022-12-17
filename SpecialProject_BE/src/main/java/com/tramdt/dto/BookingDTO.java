package com.tramdt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class BookingDTO {

    private Long accountId;
    private Long depFlightId;
    private Long retFlightId;
    private Double depTotalPrice;
    private Double retTotalPrice;
    private String depBranch;
    private String retBranch;
    private List<PassengerInfoDTO> depPassengers;
    private List<PassengerInfoDTO> retPassengers;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getDepFlightId() {
        return depFlightId;
    }

    public void setDepFlightId(Long depFlightId) {
        this.depFlightId = depFlightId;
    }

    public Long getRetFlightId() {
        return retFlightId;
    }

    public void setRetFlightId(Long retFlightId) {
        this.retFlightId = retFlightId;
    }

    public Double getDepTotalPrice() {
        return depTotalPrice;
    }

    public void setDepTotalPrice(Double depTotalPrice) {
        this.depTotalPrice = depTotalPrice;
    }

    public Double getRetTotalPrice() {
        return retTotalPrice;
    }

    public void setRetTotalPrice(Double retTotalPrice) {
        this.retTotalPrice = retTotalPrice;
    }

    public String getDepBranch() {
        return depBranch;
    }

    public void setDepBranch(String depBranch) {
        this.depBranch = depBranch;
    }

    public String getRetBranch() {
        return retBranch;
    }

    public void setRetBranch(String retBranch) {
        this.retBranch = retBranch;
    }

    public List<PassengerInfoDTO> getDepPassengers() {
        return depPassengers;
    }

    public void setDepPassengers(List<PassengerInfoDTO> depPassengers) {
        this.depPassengers = depPassengers;
    }

    public List<PassengerInfoDTO> getRetPassengers() {
        return retPassengers;
    }

    public void setRetPassengers(List<PassengerInfoDTO> retPassengers) {
        this.retPassengers = retPassengers;
    }
}

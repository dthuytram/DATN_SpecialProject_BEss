package com.tramdt.dto;

import lombok.Getter;
import lombok.Setter;


public class PassengerInfoDTO {

    private String fullName;

    private String identifierCard;

    private String email;

    private String phoneNumber;

    private String gender;

    private int baggagePrice;

    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentifierCard() {
        return identifierCard;
    }

    public void setIdentifierCard(String identifierCard) {
        this.identifierCard = identifierCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBaggagePrice() {
        return baggagePrice;
    }

    public void setBaggagePrice(int baggagePrice) {
        this.baggagePrice = baggagePrice;
    }
}

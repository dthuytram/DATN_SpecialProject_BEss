package com.tramdt.dto;

import lombok.Data;

public class EmployeePassengerDTO {
    private Long id;
    private String fullName;
    private String identifierCard;
    private String email;
    private String phoneNumber;
    private String gender;
    private Boolean checkin;
    private int deptLuggagePrice;
    private int arvLuggagePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getCheckin() {
        return checkin;
    }

    public void setCheckin(Boolean checkin) {
        this.checkin = checkin;
    }

    public int getDeptLuggagePrice() {
        return deptLuggagePrice;
    }

    public void setDeptLuggagePrice(int deptLuggagePrice) {
        this.deptLuggagePrice = deptLuggagePrice;
    }

    public int getArvLuggagePrice() {
        return arvLuggagePrice;
    }

    public void setArvLuggagePrice(int arvLuggagePrice) {
        this.arvLuggagePrice = arvLuggagePrice;
    }
}

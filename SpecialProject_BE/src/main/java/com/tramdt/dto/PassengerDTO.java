package com.tramdt.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;


public class PassengerDTO {
    private Long id;
    private String fullName;
    private String email;
    private LocalDate birthDate;
    private String identifierCard;
    private String gender;
    private String phoneNumber;
    private String address;
    private List<String> backendMessage;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentifierCard() {
        return identifierCard;
    }

    public void setIdentifierCard(String identifierCard) {
        this.identifierCard = identifierCard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getBackendMessage() {
        return backendMessage;
    }

    public void setBackendMessage(List<String> backendMessage) {
        this.backendMessage = backendMessage;
    }
}

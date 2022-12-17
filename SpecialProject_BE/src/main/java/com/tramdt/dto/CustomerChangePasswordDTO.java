package com.tramdt.dto;


import lombok.Data;

import java.util.List;

public class CustomerChangePasswordDTO {
    private Long id;
    private String password;
    private String newPassword;
    private String confirmPassword;
    private List<String> backendMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<String> getBackendMessage() {
        return backendMessage;
    }

    public void setBackendMessage(List<String> backendMessage) {
        this.backendMessage = backendMessage;
    }
}

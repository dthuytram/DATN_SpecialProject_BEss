package com.tramdt.service;

public interface EmailService {

    void sendBookingCode(Long code, String branch, Long accountId);

    void sendSimpleMessage(String to, String subject, String text);
}

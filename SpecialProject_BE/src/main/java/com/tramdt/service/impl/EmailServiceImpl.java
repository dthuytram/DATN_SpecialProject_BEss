package com.tramdt.service.impl;

import com.tramdt.repository.AccountRepository;
import com.tramdt.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendBookingCode(Long code, String branch, Long accountId) {
        String sendTo = accountRepository.findById(accountId).get().getEmail();
        System.out.println("GỬI MAIL ĐẾN%%%%%");
        System.out.println(sendTo);

        StringBuilder text = new StringBuilder();
        text.append("Your flight reservation has been successfully confirmed. Please find your e-ticket attached.");

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(sendTo);
        msg.setFrom("annanguyendn123@gmail.com");
        msg.setReplyTo("annanguyendn123@gmail.com");
        msg.setCc("annanguyendn123@gmail.com");
        msg.setBcc("annanguyendn123@gmail.com");
        msg.setText("annanguyendn123@gmail.com");
        Date date = new Date(System.currentTimeMillis());
        msg.setSentDate(date);
        String subject = "[CBG Air] Your " +
                branch +
                " E-ticket - Booking ID " +
                code;
        msg.setSubject(subject);
        msg.setText(text.toString());
        System.out.println("MSG%%%%");
        System.out.println(ObjectUtils.isEmpty(msg));
        emailSender.send(msg);
    }


    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("CGB Airlines <CGBAirlines@gmail.com>");
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(text);
        emailSender.send(msg);
    }
}

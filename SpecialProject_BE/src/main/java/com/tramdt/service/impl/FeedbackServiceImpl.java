package com.tramdt.service.impl;

import com.tramdt.model.Feedback;
import com.tramdt.repository.FeedbackRepository;
import com.tramdt.service.FeedbackService;
import com.tramdt.service.search.FeedbackSpecification;
import com.tramdt.service.search.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    private JavaMailSender emailSender;

//    @Override
//    public Page<Feedback> findAll(Pageable pageable) {
//        return feedbackRepository.findAll(pageable);
//    }

    @Override
    public Page<Feedback> findAll(int page) {
        Pageable pageable = PageRequest.of(page - 1, 4, Sort.by("id"));
        Page<Feedback> feedbacks = feedbackRepository.findAll(pageable);
        return feedbacks;
    }


    @Override
    public Feedback findById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public Specification<Feedback> getFilter(String customerName, String createDate, String processStatus) {
        List<FeedbackSpecification> specs = new ArrayList<>();
        Specification<Feedback> spec;
        // search theo
        // customer of name
        if (!"".equals(customerName) && !"undefined".equals(customerName)) {
            specs.add(new FeedbackSpecification(new SearchCriteria("customerName", "like", customerName)));
        }
        // customer of created day
        if (!"".equals(createDate) && !"undefined".equals(createDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateTime = LocalDate.parse(createDate, formatter);
            System.out.println(dateTime instanceof LocalDate);
            specs.add(new FeedbackSpecification(new SearchCriteria("createDate", "equal", createDate)));
        }
        if (!"".equals(processStatus) && !"undefined".equals(processStatus)) {
            specs.add(new FeedbackSpecification(new SearchCriteria("processStatus", "equal", processStatus)));
        }
        if (specs.size() != 0) {
            spec = Specification.where(specs.get(0));
            for (int i = 1; i < specs.size(); i++) {
                assert spec != null;
                spec = spec.and(specs.get(i));
            }
            return spec;
        }
        return null;
    }

    @Override
    public Page<Feedback> findFeedbackByCriteria(Specification<Feedback> specs, int page) {
        Pageable pageable = PageRequest.of(page - 1, 4);
        Page<Feedback> feedbackPages = feedbackRepository.findAll(specs, pageable);
        return feedbackPages;
    }

    @Override
    public List<Feedback> findAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public void sendEmail(String email, String textStr) {
        StringBuilder text = new StringBuilder();
        text.append("Your flight reservation has been successfully confirmed. Please find your e-ticket attached.");

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setFrom("annanguyendn123@gmail.com");
        msg.setReplyTo("annanguyendn123@gmail.com");
        msg.setCc("annanguyendn123@gmail.com");
        msg.setBcc("annanguyendn123@gmail.com");
        msg.setText("annanguyendn123@gmail.com");
        Date date = new Date(System.currentTimeMillis());
        msg.setSentDate(date);
        String subject = "Lời nhắn từ admin: " +
                textStr +
                "\n~~~~From admin~~~~";
        msg.setSubject(subject);
        msg.setText(text.toString());
        System.out.println("MSG%%%%");
        System.out.println(ObjectUtils.isEmpty(msg));
        emailSender.send(msg);
    }

}

package com.tramdt.controller;

import com.tramdt.exception.excep.ViolatedException;
import com.tramdt.model.Feedback;
import com.tramdt.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    private FeedbackService feedbackService;

    // Method save Feedback entity
    @PostMapping("/home/save-feedback")
    public ResponseEntity<Feedback> saveFeedback(@Valid @RequestBody Feedback feedback, BindingResult bindingResult)
            throws Exception  {
        if (bindingResult.hasFieldErrors()) {
            throw new ViolatedException(bindingResult);
        }
        try {
            feedbackService.save(feedback);
        } catch (Exception ex) {
            throw new Exception("Không thể lưu được đối tượng xuống db, vui lòng kiểm tra tên column trong model");
        }

        return ResponseEntity.ok(feedback);
    }

}

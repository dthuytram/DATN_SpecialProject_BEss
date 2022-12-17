package com.tramdt.controller;
import com.tramdt.model.TransactionDetail;
import com.tramdt.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class TransactionDetailController {
    @Autowired
    TransactionDetailService transactionDetailService;

    @GetMapping("/checkin")
    public ResponseEntity<List<TransactionDetail>> searchTransactionDetail(@RequestParam(name = "id", defaultValue ="") Long id){
        List<TransactionDetail> transactionDetails = transactionDetailService.findByTransactionDetail(id);
        if (transactionDetails.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactionDetails);
    }


}

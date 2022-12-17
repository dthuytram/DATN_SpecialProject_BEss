package com.tramdt.controller;

import com.tramdt.dto.ReportAirline;
import com.tramdt.dto.ReportPrice;
import com.tramdt.dto.ReportPriceDTO;
import com.tramdt.service.ReportPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportPriceController {
    // Thành
    @Autowired
    private ReportPriceService transactionService;

    @PostMapping("/pricereport")
    public List<ReportPrice> getAllTransactions(@RequestBody ReportPriceDTO reportPriceDTO){
        List<ReportPrice> reportPrice = transactionService.findAllTransaction(reportPriceDTO);
        return transactionService.findAllTransaction(reportPriceDTO);
    }
    @PostMapping("/airlinereport")
    public List<ReportAirline> getAllAirline(@RequestBody ReportPriceDTO reportPriceDTO){
        return transactionService.findAllTransactionByAirline(reportPriceDTO);
    }
}

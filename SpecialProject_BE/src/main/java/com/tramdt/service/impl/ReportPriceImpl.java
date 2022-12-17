package com.tramdt.service.impl;

import com.tramdt.dto.ReportAirline;
import com.tramdt.dto.ReportPrice;
import com.tramdt.dto.ReportPriceDTO;
import com.tramdt.repository.ReportAirlineRepository;
import com.tramdt.repository.ReportPriceRepository;
import com.tramdt.service.ReportPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReportPriceImpl implements ReportPriceService {
    // Thành
    @Autowired
    private ReportPriceRepository reportPriceRepository;

    @Autowired
    private ReportAirlineRepository reportAirlineRepository;

    @Override
    public List<ReportPrice> findAllTransaction(ReportPriceDTO reportPriceDTO) {
        LocalDateTime date1 = LocalDateTime.of(reportPriceDTO.getDate1(), LocalTime.of(0,0));
        LocalDateTime date2 = LocalDateTime.of(reportPriceDTO.getDate2(), LocalTime.of(23,59));
//        LocalDateTime date3 = null;
//        LocalDateTime date4 = null;
//        if (reportPriceDTO.getDate3() != null && reportPriceDTO.getDate4() != null){
//            date3 =  LocalDateTime.of(reportPriceDTO.getDate3(), LocalTime.of(0,0));
//            date4 = LocalDateTime.of(reportPriceDTO.getDate4(), LocalTime.of(23,59));
//            return reportPriceRepository.findTotalPricePerDate(date1,date2,date3,date4);
//        }else {
//
//        }
        return reportPriceRepository.findTotalPricePerDate(date1,date2, null, null);
    }

    @Override
    public List<ReportAirline> findAllTransactionByAirline(ReportPriceDTO reportPriceDTO) {
        LocalDateTime date1 = LocalDateTime.of(reportPriceDTO.getDate1(), LocalTime.of(0,0));
        LocalDateTime date2 = LocalDateTime.of(reportPriceDTO.getDate2(), LocalTime.of(23,59));
        return reportAirlineRepository.findTotalAirlinePerDate(date1,date2);
    }
}

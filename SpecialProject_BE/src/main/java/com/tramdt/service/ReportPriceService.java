package com.tramdt.service;



import com.tramdt.dto.ReportAirline;
import com.tramdt.dto.ReportPrice;
import com.tramdt.dto.ReportPriceDTO;

import java.util.List;

public interface ReportPriceService {
    List<ReportPrice> findAllTransaction(ReportPriceDTO reportPriceDTO);

    List<ReportAirline> findAllTransactionByAirline(ReportPriceDTO reportPriceDTO);
}

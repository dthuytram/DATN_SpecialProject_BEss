package com.tramdt.service;
import com.tramdt.dto.BookingDTO;
import com.tramdt.model.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    void saveTransactionDetail(BookingDTO booking);

    List<TransactionDetail> findByTransactionDetail(Long id);
}

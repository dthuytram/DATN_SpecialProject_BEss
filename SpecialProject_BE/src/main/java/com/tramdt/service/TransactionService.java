package com.tramdt.service;

import com.tramdt.model.Transaction;
import com.tramdt.model.TransactionDetail;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    String WAITING = "Chờ thanh toán";
    String CANCELED = "Đã hủy";
    String PAID = "Đã thanh toán";

    Page<Transaction> getTransactionsByAccountId(Long accountId, int currentPage);

    Transaction save(Transaction transaction);

    Transaction createTransaction(Long flightScheduleId, Long accountId, Double totalPrice);

    Transaction findById(Long id);

    List<Transaction> findUnpaidTransactionByAccount(Long accountId);

    Transaction findByIdAndPhone(Long id, String phone);

    Transaction payTransaction(Long id, String taxCode);

    List<Transaction> payTransactions(List<Long> ids, String taxCode);

    Transaction cancelTransaction(Long id);

    List<TransactionDetail> findTransactionDetails(Long id);

    List<Transaction> findOverdueTransaction();

    List<Transaction> saveAll(List<Transaction> transactions);

    public Optional<Transaction> getById(Long id) ;

    public String generateQrCode(Transaction sdi, String imagePath) ;

    public String generateQrCodeOr(Long id, String imagePath) ;

}

package com.tramdt.service.impl;

import com.tramdt.config.sercurity.secure.QRUtils;
import com.tramdt.model.*;
import com.tramdt.repository.BillRepository;
import com.tramdt.repository.TransactionDetailRepository;
import com.tramdt.repository.TransactionRepository;
import com.tramdt.service.TransactionService;
import com.tramdt.utils.BillCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class TransactionServiceImpl implements TransactionService {
    private static final int ORDER_QR_CODE_SIZE_WIDTH = 300;
    private static final int ORDER_QR_CODE_SIZE_HEIGHT = 300;

    @Autowired
    private TransactionRepository transactionRepository;
    Sort sort = Sort.by(Sort.Direction.ASC, "createdTime");
    Pageable page = PageRequest.of(0, 2, sort);
    @Override
    public Page<Transaction> getTransactionsByAccountId(Long accountId, int currentPage) {
        if (currentPage > 0 ){
            Pageable page = PageRequest.of(--currentPage, 2, sort);
            return transactionRepository.findByAccount_IdIs(accountId, page);
        }
        return transactionRepository.findByAccount_IdIs(accountId, page);
    }




    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Autowired
    private BillRepository billRepository;

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> findUnpaidTransactionByAccount(Long accountId) {
        List<Transaction> transactions = transactionRepository.findUnpaidByAccountId(accountId);
        if (transactions.size() > 0) {
            return transactions;
        } else {
            return null;
        }
    }

    @Override
    public Transaction findByIdAndPhone(Long id, String phone) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (optional.isPresent()) {
            Transaction transaction = optional.get();
            if (phone.equals(transaction.getAccount().getPhoneNumber())) {
                return transaction;
            } else {
                List<TransactionDetail> transactionDetails = transactionDetailRepository.findByTransaction_Id(id);
                if (transactionDetails.size() > 0) {
                    for (TransactionDetail detail : transactionDetails) {
                        if (phone.equals(detail.getPassenger().getPhoneNumber())) {
                            return transaction;
                        }
                    }
                }
            }
        }
        return null;
    }


    @Override
    public Transaction payTransaction(Long id, String taxCode) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        Transaction transaction = optional.get();
        transaction.setStatus(TransactionService.PAID);
        Bill bill = new Bill();
        bill.setDateCreated(LocalDateTime.now());
        bill.setTransaction(transaction);
        bill.setTaxCode(taxCode);
        bill = billRepository.save(bill);
        bill.setBillCode(BillCodeGenerator.generate(bill.getId()));
        billRepository.save(bill);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction cancelTransaction(Long id) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        Transaction transaction = optional.get();
        transaction.setStatus(TransactionService.CANCELED);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> payTransactions(List<Long> ids, String taxCode) {
        List<Transaction> transactions = new LinkedList<>();
        for (Long id : ids) {
            Transaction transaction = payTransaction(id, taxCode);
            if (transaction != null) {
                transactions.add(transaction);
            } else {
                return null;
            }
        }
        return transactions.size() > 0 ? transactions : null;
    }

    @Override
    public List<TransactionDetail> findTransactionDetails(Long id) {
        List<TransactionDetail> details = transactionDetailRepository.findByTransaction_Id(id);
        return details.size() > 0 ? details : null;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // create transaction
    @Override
    public Transaction createTransaction(Long flightScheduleId, Long accountId, Double totalPrice) {
        Transaction transaction = new Transaction();
        FlightSchedule flightSchedule = new FlightSchedule();
        LocalDateTime createdDateTime = LocalDateTime.now();
        LocalDateTime dueDateTime = createdDateTime.plusHours(2);
        Account account = new Account();
        account.setId(accountId);
        flightSchedule.setId(flightScheduleId);
        transaction.setFlightSchedule(flightSchedule);
        transaction.setAccount(account);
        transaction.setPrice(totalPrice);
        transaction.setStatus(TransactionService.WAITING);
        transaction.setCreatedTime(createdDateTime);
        transaction.setDueTime(dueDateTime);
        return transaction;
    }

    @Override
    public List<Transaction> findOverdueTransaction() {
        return transactionRepository.findOverdueTransaction(LocalDateTime.now());
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> transactions) {
        return transactionRepository.saveAll(transactions);
    }

    @Override
    public Optional<Transaction> getById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public String generateQrCode(Transaction sdi, String imagePath) {
        String prettyData = QRUtils.prettyObject(sdi);
        String qrCode = QRUtils.generateQrCode(prettyData, ORDER_QR_CODE_SIZE_WIDTH, ORDER_QR_CODE_SIZE_HEIGHT, imagePath);
        return qrCode;
    }

    @Override
    public String generateQrCodeOr(Long id, String imagePath) {
        String prettyData = QRUtils.prettyObject(id);
        String qrCode = QRUtils.generateQrCode(prettyData, ORDER_QR_CODE_SIZE_WIDTH, ORDER_QR_CODE_SIZE_HEIGHT, imagePath);
        return qrCode;
    }
}

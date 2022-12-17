package com.tramdt.service.impl;

import com.tramdt.dto.BookingDTO;
import com.tramdt.dto.PassengerInfoDTO;
import com.tramdt.model.Passenger;
import com.tramdt.model.Transaction;
import com.tramdt.model.TransactionDetail;
import com.tramdt.repository.TransactionDetailRepository;
import com.tramdt.service.EmailService;
import com.tramdt.service.PassengerService;
import com.tramdt.service.TransactionDetailService;
import com.tramdt.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private EmailService emailService;

    @Override
    public void saveTransactionDetail(BookingDTO booking) {
        // transfer to passenger
        // add passenger
        List<Passenger> passengerList = passengerService.addAllPassengers(booking.getDepPassengers());
        Transaction depTransaction = transactionService.createTransaction(booking.getDepFlightId(), booking.getAccountId(), booking.getDepTotalPrice());
        Transaction finalDepTransaction =  transactionService.save(depTransaction);
        passengerList.forEach((val) -> {
            addDetail(finalDepTransaction, val, booking.getDepPassengers());
        });
        emailService.sendBookingCode(finalDepTransaction.getId(), booking.getDepBranch(), booking.getAccountId());
        // if round-trip
        if (booking.getRetFlightId() != 0) {
            passengerList = passengerService.addAllPassengers(booking.getRetPassengers());
            Transaction retTransaction = transactionService.createTransaction(booking.getRetFlightId(), booking.getAccountId(), booking.getRetTotalPrice());
            Transaction finalRetTransaction =  transactionService.save(retTransaction);
            passengerList.forEach((val) -> {
                addDetail(finalRetTransaction, val, booking.getRetPassengers());
            });
            emailService.sendBookingCode(finalRetTransaction.getId(), booking.getRetBranch(), booking.getAccountId());
        }
    }

    @Override
    public List<TransactionDetail> findByTransactionDetail(Long id) {
        return transactionDetailRepository.findAllByTransactionIdAndPassenger_CheckinIsFalse(id);
    }

    private void addDetail(Transaction transaction, Passenger passenger, List<PassengerInfoDTO> baggageInfo) {
        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTransaction(transaction);
        transactionDetail.setPassenger(passenger);
        baggageInfo.forEach((val) -> {
            if(val.getFullName().equals(passenger.getFullName())) {
                transactionDetail.setBaggage(getBaggage(val.getBaggagePrice()));
            }
        });
        transactionDetailRepository.save(transactionDetail);
    }

    private byte getBaggage(int money) {
        switch (money) {
            case 170000:
                return 15;
            case 225000:
                return 20;
            case 275000:
                return 25;
            default:
                return 7;
        }
    }
}

package com.tramdt.dto;

import lombok.Data;

import java.util.List;


public class TransactionPassengerDTO {
    private List<EmployeeTransactionDTO> transactions;
    private List<EmployeePassengerDTO> passengers;

    public List<EmployeeTransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<EmployeeTransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public List<EmployeePassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<EmployeePassengerDTO> passengers) {
        this.passengers = passengers;
    }
}

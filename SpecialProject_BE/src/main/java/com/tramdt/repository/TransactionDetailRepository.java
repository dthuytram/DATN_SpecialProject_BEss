package com.tramdt.repository;

import com.tramdt.model.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {

    List<TransactionDetail> findByTransaction_Id(Long id);
    List<TransactionDetail> findAllByTransactionIdAndPassenger_CheckinIsFalse(Long id);

}

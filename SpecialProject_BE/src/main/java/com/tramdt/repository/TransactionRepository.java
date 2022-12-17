package com.tramdt.repository;

import com.tramdt.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByAccount_IdIs(Long accountId, Pageable pageable);

    Page<Transaction> findByAccount_IdIsAndStatusIs(Long accountId, String status, Pageable pageable);


    @Query(value = "SELECT t FROM Transaction t WHERE t.account.id = ?1 AND t.status = 'chờ thanh toán' and t.price > 0")
    List<Transaction> findUnpaidByAccountId(Long accountId);

    @Query(value = "SELECT t FROM Transaction t WHERE t.dueTime <= ?1 AND t.status = 'chờ thanh toán'")
    List<Transaction> findOverdueTransaction(LocalDateTime dueTime);

}
